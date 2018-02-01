package lambda.skill;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.Set;

public class TunerSkillStatusRequestStreamHandler extends SpeechletRequestStreamHandler {

    private static final Set<String> supportedApplicationIds = new HashSet<String>();

     static {
  System.setProperty("com.amazon.speech.speechlet.servlet.disableRequestSignatureCheck", "true");
   //     String appId = "amzn1.ask.skill.e0fa9258-4027-44c6-82a6-589f0d564138";
 //       supportedApplicationIds.add(appId);
    }


    public TunerSkillStatusRequestStreamHandler() {
        super(new TunerSkillSpeechlet(), supportedApplicationIds);
    }
}
