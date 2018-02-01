package lambda.skill;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.ui.OutputSpeech;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.amazon.speech.ui.SsmlOutputSpeech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

/**
 * Created by quest on 29/1/18.
 */

public class ExpertAssistantSpeechlet implements SpeechletV2  {

    public static final String SPEAK_TAGS = "<speak>%s</speak>";
    private static final Logger log = LoggerFactory.getLogger(TunerSkillSpeechlet.class);
    private ArrayList<String> mSymptomsList = new ArrayList<>() ;
    private Intent mIntent;

    public ExpertAssistantSpeechlet() {
        getWelcomeResponse();
    }

    @Override
    public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {

    }

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
        //mSymptomsList = new ArrayList<>();
        return getWelcomeResponse();
    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
        log.info("Intent ", requestEnvelope.getRequest().getIntent());

        mIntent  = requestEnvelope.getRequest().getIntent();
        Session session = requestEnvelope.getSession();

        String intentName = (mIntent != null) ? mIntent.getName() : null;

        switch (intentName){
            case "diseaseSymptoms":
             return storeSymptoms();

            case "continueOptions" :
                return chooseContinueOptions();
            default:
              return invalidIntent();
        }
    }


    private SpeechletResponse storeSymptoms() {
        Optional<String> symptomData = slotValue(mIntent, "symptoms");

        log.info("symptom"+symptomData);
        if (symptomData.isPresent()) {
            log.info("Symptom");
            mSymptomsList.add(symptomData.get());
        }

        String speech = "Do you have any other symptoms";

        OutputSpeech repromptOutputSpeech;
        SsmlOutputSpeech outputSpeech = null;
        outputSpeech = new SsmlOutputSpeech();
        String speechText = String.format(SPEAK_TAGS, speech);
        outputSpeech.setSsml(speechText);


        repromptOutputSpeech = new PlainTextOutputSpeech();
        ((PlainTextOutputSpeech) repromptOutputSpeech).setText("Can you say it again?");

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptOutputSpeech);
        //session ends after this execution
        return SpeechletResponse.newAskResponse(outputSpeech, reprompt);

    }

    private SpeechletResponse chooseContinueOptions() {
        
        Optional<String> symptomData = slotValue(mIntent, "option");
        String speech = null;

        OutputSpeech repromptOutputSpeech;
        SsmlOutputSpeech outputSpeech = null;
        outputSpeech = new SsmlOutputSpeech();
        
        if(symptomData.isPresent()){
            if(symptomData.get().equalsIgnoreCase("yes")){
                speech = "Tell me your symptoms";
            }
            else if(symptomData.get().equalsIgnoreCase("no")){
                speech = "you have fever";
            }else{
                speech = "I didn't get that";
            }
        }
        String speechText = String.format(SPEAK_TAGS, speech);
        outputSpeech.setSsml(speechText);


        repromptOutputSpeech = new PlainTextOutputSpeech();
        ((PlainTextOutputSpeech) repromptOutputSpeech).setText("Can you say it again?");

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptOutputSpeech);
        //session ends after this execution
        return SpeechletResponse.newAskResponse(outputSpeech, reprompt);
        
    }

    @Override
    public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {

    }


    /**
     * Creates and returns a {@code SpeechletResponse} with a welcome message.
     *
     * @return SpeechletResponse spoken and visual response for the given intent
     */
    private SpeechletResponse getWelcomeResponse()
    {
        String speechText = "Welcome to the Alexa World, you can tell your symptoms";

        // Create the Simple card content.

        SimpleCard card = new SimpleCard();
        card.setTitle("HelloWorld");
        card.setContent(speechText);

        // Create the plain text output.

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }


    /**
     * Method to get invalid intent response
     *
     * @return SpeechletResponse spoken response for invalid intent
     */
    private SpeechletResponse invalidIntent() {
        String speechText = Constants.RESPONSE_INVALID_INTENT;
        String cardString = Constants.CARD_TEXT_INVALID_INTENT;
        SimpleCard cardData = SkillResponse.displayCard(cardString);
        Reprompt reprompt = SkillResponse.commonReprompt();
        return SkillResponse.newAskResponse(speechText, reprompt, cardData);
    }

    /**
     * Method used for get the slot value from the intent.
     *
     * @param intent   intent
     * @param slotName slot name
     * @return slot value
     */
    public Optional<String> slotValue(Intent intent, String slotName) {
        if (intent == null) {
            return Optional.empty();
        }
        Map<String, Slot> slots = intent.getSlots();
        Slot slotValue = slots.get(slotName);
        if (slotValue == null || slotValue.getValue() == null) {
            return Optional.empty();
        }
        return Optional.of(slotValue.getValue());
    }

}
