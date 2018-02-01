package lambda.skill;

/**
 * Created by midhun on 15/6/17.
 */

public class Constants {

    public static final String HIGH_TEMP = "85";
    public static final String LOW_TEMP = "59";
    //Intent names
    public static final String INTENT_SET_TEMP_PERSONAL = "SetTempPersonal";
    public static final String INTENT_SET_TEMP = "SetTemp";
    public static final String INTENT_SET_TEMP_ONESHOT = "SetTempOneShot";
    public static final String INTENT_SET_TEMP_PERSONAL_ONESHOT = "SetTempPersonalOneShot";
    public static final String INTENT_SET_TEMP_OCCUPANT = "SetTempOccupant";
    public static final String INTENT_SET_TEMP_OCCUPANT_ONESHOT = "SetTempOccupantOneShot";
    public static final String INTENT_SET_TEMP_WARMER = "SetTempWarmer";
    public static final String INTENT_SET_TEMP_COLDER = "SetTempColder";
    public static final String INTENT_GET_TEMP = "GetTemp";
    public static final String INTENT_CANCEL = "AMAZON.CancelIntent";
    public static final String INTENT_HELP = "AMAZON.HelpIntent";
    public static final String INTENT_LAUNCH = "AMAZON.onLaunch";
    public static final String TABLE_NAME = "ContactData";

    public static final String SLOT_TEMP = "Temp";
    public static final String SLOT_OCCUPANT = "Occupant";
    public static final String CARD_TITLE = "FlexConnect";

    public static final String INTENT = "Intent";
    public static final String ATTRIBUTE_OCCUPANT = "Occupant";
    public static final String TEMPERATURE = "Temperature";
    public static final String API_URL = "https://api.amazon.com/auth/o2/tokeninfo?access_token=";
    public static final String SPEAK_TAGS = "<speak>%s</speak>";
    public static final String TEMPERATURE_LOW = "Low";
    public static final String TEMPERATURE_HIGH = "High";
    public static final String JSON_NODE_STATE = "state";
    public static final String JSON_NODE_DESIRED = "desired";
    public static final String JSON_NODE_USER_POSITION = "userPosition";
    public static final String JSON_NODE_CLIMATE = "climate";
    public static final String USER_DRIVER = "driver";
    public static final String USER_PASSENGER = "passenger";
    public static final String USER_R_LEFT = "rearleft";
    public static final String USER_R_RIGHT = "rearright";

    public static final int TIMEOUT = 0;
    public static final int SEAT_DRIVER = 0;
    public static final int SEAT_PASSENGER = 1;
    public static final int SEAT_R_RIGHT = 2;
    public static final int SEAT_R_LEFT = 3;
    public static final int DEFAULT_SEAT = 4;
    public static final int TEMPERATURE_CONSTANT = 5;

    public static final String SPEECH_TEXT_WHAT_TEMPERATURE = "What temperature?";
    public static final String SPEECH_BREAK_TIME = "<break time=\"0.2s\" />";
    public static final String CARD_TEXT_LAUNCH_RESPONSE = "Welcome to Flex connect. Ask Flex Connect to adjust climate temperature, tune to Radio or make a call to contact name. Let's try it.";
    public static final String CARD_TEXT_INVALID_USER = "I couldn't recognize you. \nPlease make sure the skill is enabled in Alexa app and try login again";
    public static final String RESPONSE_DEFAULT_LAUNCH = "Welcome to Flex connect.<break time=\"0.3s\" />ask flex connect to adjust climate temperature, tune to Radio or make a call to contact name.<break time=\"0.3s\" /> Let's try it";
    public static final String RESPONSE_HELP = "You can tell or ask flex connect adjust climate temperature.<break time=\"0.3s\" /> Let's try it.";
    public static final String RESPONSE_INVALID_USER = "I couldn't recognize you" + Constants.SSML_TAG_BREAK_2SEC + " Please make sure the skill is enabled in Alexa app and try login again";
    public static final String RESPONSE_INVALID_INTENT = "I do not seem to understand what you were intending to do.<break time=\"0.3s\" />  How can I help you?";
    public static final String CARD_TEXT_INVALID_INTENT = "I do not seem to understand what you were intending to do. How can I help you?";
    public static final String RESPONSE_GOOD_BYE = "The flex connect says goodbye";
    public static final String RESP_TELL_ME = "Tell me what i want to do?";
    public static final String RESPONSE_CALL_CONTACT_FAILED = "i couldn't get that" + Constants.SSML_TAG_BREAK_2SEC + "you can say" + Constants.SSML_TAG_BREAK_2SEC + "Call" + Constants.SSML_TAG_BREAK_2SEC + "then a contact name";
    public static final String CARD_TEXT_CALL_CONTACT_FAILED = "I couldn't get that, you can say CALL then a Contact name";
    public static final String RESPONSE_PHONE_NOT_READY = "It seems phone not ready or contact sync in progress" + Constants.SSML_TAG_BREAK_2SEC + "please try after some time";
    public static final String CARD_TEXT_PHONE_NOT_READY = "It seems phone not ready or contact sync in progress. \n Please try after some time";
    public static final String RESPONSE_MAKE_CALL_FAILED = "I couldn't get that" + Constants.SSML_TAG_BREAK_3SEC + "you can say" + Constants.SSML_TAG_BREAK_2SEC + "Make call" + Constants.SSML_TAG_BREAK_2SEC + "then a contact name";
    public static final String CARD_TEXT_MAKE_CALL_FAILED = "I couldn't get that, you can say MAKE CALL then a Contact name";
    public static final String RESPONSE_I_DONT_KNOW = "Sorry" + Constants.SSML_TAG_BREAK_2SEC + "I don't know how to help you with that";
    public static final String CARD_TEXT_I_DONT_KNOW = "Sorry, I don't know how to help you with that";
    public static final String RESPONSE_NUM_CAN_NOT_DIALED = "Sorry" + Constants.SSML_TAG_BREAK_2SEC + "the selected contact cannot be dialed" + Constants.SSML_TAG_BREAK_2SEC + "please check the number and try again";
    public static final String CARD_TEXT_NUM_CAN_NOT_DIALLED = "Sorry, the selected contact cannot be dialed. \n" + "Please check the number and try again";
    public static final String RESPONSE_CALL_DIAL_NUMBER_FAILED ="i couldn't get that Dial number is not supported" + Constants.SSML_TAG_BREAK_2SEC;
    public static final String CARD_TEXT_DIAL_CONTACT_FAILED = "I couldn't get that, you can say Dial then a Number";


    public static String IOT_TOPIC = "$aws/things/%s/shadow/update";
    public static String PAYLOAD_FOR_ALL_USER = "{\"state\":{\"reported\": {\"climate\": {\"driver\":%s,\"passenger\":%s,\"rearleft\":%s,\"rearright\":%s,\"seat_position\":\"all\"}}}}";
    public static String PAYLOAD_FOR_OCCUPANT = "{\"state\":{\"reported\": {\"climate\": {\"%s\":%s,\"seat_position\":\"%s\"}}}}";

    //RadioTuner payloads
    public static String PAYLOAD_RADIO_WITH_FREQUENCY = "{\"state\":{\"reported\": {\"radio\": {\"band\": \"%s\",\"frequency\": \"%s\"}}}}";
    public static String PAYLOAD_RADIO_START = "{\"state\":{\"reported\": {\"radio\": {\"command\": \"%s\"}}}}";
    public static String PAYLOAD_RADIO_LIST_STATIONS_BAND = "{\"state\":{\"reported\": {\"radio\": {\"band\": \"%s\"}}}}";



    //RadioTuner
    public static final String BAND = "radio_type";
    public static final String LEFT_FREQ = "frq_left";
    public static final String RIGHT_FREQ = "frq_right";

    //RadioTuner intents
    public static final String INTENT_SET_FREQUENCY = "StartRadioToBandAndFrequencyOneShot";
    public static final String INTENT_SET_FREQUENCY_WITHOUT_DECIMAL = "StartRadioToFrequencyOneShot";
    public static final String INTENT_START_RADIO = "startRadio";
    public static final String INTENT_LIST_STATIONS = "listStations";
    public static final String INTENT_START_RADIO_BAND = "startRadioWithBand";
    public static final String INTENT_TUNE_TO_BAND_FREQUENCY = "tuneFrequencyBand";


    public static final String AM = "A M";
    public static final String FM = "F M";

    /**
     * Min value for AM station range
     */
    public static final int AM_MIN_VALUE = 530;
    /**
     * Max value for AM station range
     */
    public static final int AM_MAX_VALUE = 1710;
    /**
     * Min value for AM station range
     */
    public static final double FM_MIN_VALUE = 87.7;
    /**
     *
     * Min value for AM station range
     */
    public static final double FM_MAX_VALUE = 107.9;

/**
     * Intents used to Phone skill feature implementation.
     */
    public static final String INTENT_CALL_CONTACT = "PhoneCallIntent";
    public static final String INTENT_CONFIRM_CONTACT = "PhoneContactConfirmIntent";
    public static final String INTENT_MAKE_CALL = "PhoneMakeCallIntent";
    public static final String INTENT_DIAL_NUMBER ="dialNumber" ;

    /**
     * Slots used to Phone skill feature implementation.
     */
    public static final String SLOT_CONTACT_NAME = "contactName";
    public static final String SLOT_CONFIRM_CONTACT_FIRST_NAME = "searchedName";
    public static final String SLOT_CONFIRM_CONTACT_SECOND_NAME = "searchedLastName";
    public static final String SLOT_SEARCH_CONTACT_SECOND_NAME = "contactSecondName";
    public static final String SLOT_CONTACT_INDEX = "serialNumber";
    public static final String SLOT_DIAL_NUMBER ="Number" ;


    /**
     * Speech Synthesis Markup Language tags used in Phone skill response.
     */
    public static final String SSML_TAG_SPEAK_START = "<speak>";
    public static final String SSML_TAG_SPEAK_END = "</speak>";
    public static final String SSML_TAG_BREAK_2SEC = "<break time=\"0.2s\" />";
    public static final String SSML_TAG_BREAK_3SEC = "<break time=\"0.3s\" />";

    public static String PAYLOAD_PHONE_CONTACT = "{\"state\": {\"reported\": {\"phone\": {\"contactNumber\": \"%s\"}}}}";


    //Variables to handle session
    public static final String PHONE_SKILL = "phoneSkill";
    public static final String PHONE_CONFIRM_PENDING = "contactConfirmPending";
    public static final String NO_PENDING_INTENT = "noPendingIntent";

    // Phone common re-prompt
    public static String commonRePromptText = "Sorry I didn't get that can you say that again?";

    public Constants() {

    }

}
