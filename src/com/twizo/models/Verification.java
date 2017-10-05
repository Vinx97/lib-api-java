package com.twizo.models;

/**
 * This file is part of the Twizo Java API
 *
 * For the full copyright and licence information, please view the Licence file that was distributed
 * with this source code
 *
 * (c) Twizo - info@twizo.com
 */
public class Verification {

  /**
   * String, not null. The application used for sending the verification.
   */
  private String applicationTag;

  /**
   * Integer, can be null. The length of the token as specified when sending the verification or the
   * default value (6).
   */
  private Integer tokenLength;

  /**
   * String, can be null. The type of the token as specified when sending the verification or the
   * default value (numeric).
   */
  private String tokenType;

  /**
   * String, not null. The datetime the verification was received by the API. The datetime is in
   * ISO-8601 format.
   */
  private String createdDateTime;

  /**
   * Integer, can be null. The DCS value as specified when sending the verification.
   */
  private Integer dcs;

  /**
   * String, can be null. Currently not used yet.
   */
  private String language;

  /**
   * String, not null. The unique identifier, generated by the API, of the verification.
   */
  private String messageId;

  /**
   * Integer, can be null. When the verification is rejected or failed a reasonCode can be given
   * explaining the cause of the rejection.
   */
  private Integer reasonCode;

  /**
   * String, not null. The phone number as specified when sending the verification, the token must
   * be send to.
   */
  private String recipient;

  /**
   * Float, can be null. The sales price of the verification. When the verification was a free
   * monthly verification the sales price is 0.
   */
  private Float salesPrice;

  /**
   * String, can be null. The currency code of the salesPrice field. The value can be ‘eur’, ‘usd’
   * or ‘sgd’. The currency code is defined by the currency of your wallet.
   */
  private String salesPriceCurrencyCode;

  /**
   * String, can be null. The sender of the token in case of an SMS as specified when sending the
   * verification or the default value (Twizo).
   */
  private String sender;

  /**
   * Integer, can be null. The senderNpi of the token in case of an SMS as specified when sending
   * the verification or the automatically detected value by the API. See our tutorial ‘Sender’ for
   * more information.
   */
  private Integer senderNpi;

  /**
   * Integer, can be null. The senderNpi of the token in case of an SMS as specified when sending
   * the verification or the automatically detected value by the API. See our tutorial ‘Sender’ for
   * more information.
   */
  private Integer senderTon;

  /**
   * String, not null. The sessionId generated by the API when it was left out with the verification
   * request or the sessionId you specified at the verification request. See ‘Verification session‘
   * for more information.
   */
  private String sessionId;

  /**
   * String, not null. The status of the verification. The status and statusCode fields are bound
   * together and can have the following values:
   *
   * 0	No status: The token is generated and sent to the phone.
   * 1	Success: The token is successfully verified. The entered token matches with the token sent
   *    to the phone.
   * 2	Rejected: The verification is rejected by the system and no token is sent to the phone.
   *    The reasonCode field indicates the reason why it is rejected. See further down below for an
   *    overview of possible reasonCodes.
   * 3	Expired: The verification is expired as the token was not verified within the specified
   *    validity time.
   * 4	Failed: The verification is failed as the entered token didn’t match with the token sent to
   *    the phone. The reasonCode field indicates the reason why it is rejected. See further down
   *    below for an overview of possible reasonCodes.
   */
  private String status;

  /**
   * Integer, not null. See ‘status’ field for more information.
   */
  private Integer statusCode;

  /**
   * String, can be null. The tag as specified when sending the verification.
   */
  private String tag;

  /**
   * String, can be null. The tag value as specified when sending the verification or the default
   * value (Your verification token is: %token%)
   */
  private String bodyTemplate;

  /**
   * String, not null. The type as specified when sending the verification or the default value
   * (sms)
   */
  private String type;

  /**
   * Integer, not null. The validity in seconds as specified when sending the verification or the
   * default value (60)
   */
  private Integer validity;

  /**
   * String, not null. The datetime until when the verification is valid. This is calculated by the
   * API based on the validity field.
   */
  private String validUntilDateTime;

  public String getApplicationTag() {
    return applicationTag;
  }

  public Integer getTokenLength() {
    return tokenLength;
  }

  public String getTokenType() {
    return tokenType;
  }

  public String getCreatedDateTime() {
    return createdDateTime;
  }

  public Integer getDcs() {
    return dcs;
  }

  public String getLanguage() {
    return language;
  }

  public String getMessageId() {
    return messageId;
  }

  public Integer getReasonCode() {
    return reasonCode;
  }

  public String getRecipient() {
    return recipient;
  }

  public Float getSalesPrice() {
    return salesPrice;
  }

  public String getSalesPriceCurrencyCode() {
    return salesPriceCurrencyCode;
  }

  public String getSender() {
    return sender;
  }

  public Integer getSenderNpi() {
    return senderNpi;
  }

  public Integer getSenderTon() {
    return senderTon;
  }

  public String getSessionId() {
    return sessionId;
  }

  public String getStatus() {
    return status;
  }

  public Integer getStatusCode() {
    return statusCode;
  }

  public String getTag() {
    return tag;
  }

  public String getBodyTemplate() {
    return bodyTemplate;
  }

  public String getType() {
    return type;
  }

  public Integer getValidity() {
    return validity;
  }

  public String getValidUntilDateTime() {
    return validUntilDateTime;
  }

  @Override
  public String toString() {
    return "Verification{" +
        "applicationTag='" + applicationTag + '\'' +
        ", tokenLength=" + tokenLength +
        ", tokenType='" + tokenType + '\'' +
        ", createdDateTime='" + createdDateTime + '\'' +
        ", dcs=" + dcs +
        ", language='" + language + '\'' +
        ", messageId='" + messageId + '\'' +
        ", reasonCode=" + reasonCode +
        ", recipient='" + recipient + '\'' +
        ", salesPrice=" + salesPrice +
        ", salesPriceCurrencyCode='" + salesPriceCurrencyCode + '\'' +
        ", sender='" + sender + '\'' +
        ", senderNpi=" + senderNpi +
        ", senderTon=" + senderTon +
        ", sessionId='" + sessionId + '\'' +
        ", status='" + status + '\'' +
        ", statusCode=" + statusCode +
        ", tag='" + tag + '\'' +
        ", bodyTemplate='" + bodyTemplate + '\'' +
        ", type='" + type + '\'' +
        ", validity=" + validity +
        ", validUntilDateTime='" + validUntilDateTime + '\'' +
        '}';
  }
}