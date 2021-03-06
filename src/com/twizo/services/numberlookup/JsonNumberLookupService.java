package com.twizo.services.numberlookup;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.twizo.exceptions.TwizoException;
import com.twizo.models.NumberLookup;

import com.twizo.services.AbstractService;
import javafx.util.Pair;

/**
 * This file is part of the Twizo Java API
 *
 * For the full copyright and licence information, please view the Licence file that was distributed
 * with this source code
 *
 * (c) Twizo - info@twizo.com
 */
class JsonNumberLookupService extends AbstractService implements
    NumberLookupService {

  /**
   * Parse creation of NumberLookup results to a NumberLookup array
   *
   * @param data data which has to be parsed
   * @return Array of NumberLookups with data received after the request
   */
  @Override
  public NumberLookup[] parseNewNumberLookup(String data) {
    if (data != null) {
      return parseResults(data, "items", "total_items", false).getValue();
    } else {
      return new NumberLookup[0];
    }
  }

  /**
   * Parse the data result of status request to a NumberLookup instance
   *
   * @param data data which has to be parsed
   * @return Instance of NumberLookup received after doing the GET request to get information about
   * numberLookups
   * @throws TwizoException when something goes wrong during the process
   */
  @Override
  public NumberLookup parseNumberLookup(String data) throws TwizoException {
    if (data != null) {
      return parseToNumberLookup(data);
    } else {
      throw new TwizoException("Twizo didn't response as expected, please try again");
    }
  }

  /**
   * Parse polling results to a NumberLookup array
   *
   * @param data data which has to be parsed
   * @return Pair of batchId and array of NumberLookups
   * @throws TwizoException when something goes wrong during the process
   */
  @Override
  public Pair<String, NumberLookup[]> parseResultArray(String data) throws TwizoException {
    if (data != null) {
      return parseResults(data, "messages", "count", true);
    } else {
      throw new TwizoException("Twizo didn't response as expected, please try again");
    }
  }

  /**
   * This method parses the JSON which is returned by the server after a GET request for
   * NumberLookup results to a NumberLookup instance
   *
   * @param json JSON received from the server which has to be parsed
   * @return NumberLookup instance
   */
  private NumberLookup parseToNumberLookup(String json) {
    return gson.fromJson(json, NumberLookup.class);
  }

  /**
   * This method parses the JSON which is returned by the server after a NumberLookup creation or
   * polling for results to a NumberLookup array
   *
   * @param json Json which will be parsed
   * @param memberName member of the json to use (items or messages)
   * @param counterName name of counter in json
   * @param deliveryReport boolean to decide whether to get the batchId or not
   * @return Pair of batchId and array of NumberLookup results
   */
  private Pair<String, NumberLookup[]> parseResults(String json, String memberName,
      String counterName, boolean deliveryReport) {
    if (json != null && memberName != null && counterName != null) {
      JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

      String batchId = null;

      if (deliveryReport) {
        // Get the batchId
        batchId = jsonObject.get("batchId").getAsString();
      }

      NumberLookup[] results = new NumberLookup[jsonObject.get(counterName).getAsInt()];

      // Parse the NumberLookup values to objects
      if (jsonObject.get(counterName).getAsInt() > 0) {
        JsonArray itemArray = jsonObject.getAsJsonObject("_embedded").getAsJsonArray(memberName);

        for (int i = 0; i < results.length; i++) {
          String items = itemArray.get(i).getAsJsonObject().toString();
          results[i] = parseToNumberLookup(items);
        }
      }

      return new Pair<>(batchId, results);
    } else {
      return null;
    }
  }

}