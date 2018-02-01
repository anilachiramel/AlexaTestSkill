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
import com.amazon.speech.ui.SsmlOutputSpeech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by midhun on 12/7/17.
 */

public class TunerSkillSpeechlet implements SpeechletV2 {

    public static final String SPEAK_TAGS = "<speak>%s</speak>";
    private static final Logger log = LoggerFactory.getLogger(TunerSkillSpeechlet.class);

    public TunerSkillSpeechlet() {
    }


    @Override
    public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {

    }

    @Override
    public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {

        return null;
    }

    @Override
    public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
        log.info("Intent ", requestEnvelope.getRequest().getIntent());
        Intent intent = requestEnvelope.getRequest().getIntent();
        Session session = requestEnvelope.getSession();

        //Getting the intent name
        String intentName = intent.getName();
        String speech = "";
        String frequency = "";
        String radioType = "";

        if (intentName.equals("tune")) {
            Optional<String> optionalFrequncy = slotValue(intent, "frequency");
            log.info("frequency"+optionalFrequncy.toString());
            Optional<String> optionalRadioType = slotValue(intent, "radio_type");
            log.info("radio_type"+optionalRadioType.toString());
            if (optionalFrequncy.isPresent()) {
                log.info("fre");
                frequency = optionalFrequncy.get();
            }
            if (optionalRadioType.isPresent()) {
                radioType = optionalRadioType.get();
            }
        }

        speech = radioType + "is set to " + frequency;

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

    @Override
    public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {

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
