/*
 * Copyright (C) 2017 MEAA. All rights reserved.
 * Reproduction or transmission in whole or in part, in any form
 * or by any means, electronic, mechanical or otherwise, is
 * prohibited without the prior written consent of the copyright
 * owner.
 *
 * File Name : SkillResponse.java
 * Summary   : This file contains implementation for Alexa custom skill voice responses.
 * History   :
 * 1.0      Midhun        13-JUL-2017          Initial Version
 * 2.0      Subin         13-OCT-2017          Updated coding standard.
 */
package lambda.skill;

import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.amazon.speech.ui.SsmlOutputSpeech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class Name   : SkillResponse
 * Summary      : This class handles all voice responses from different custom skills.
 * Version      : 2.0
 */

public class SkillResponse {

    private static final Logger log = LoggerFactory.getLogger(SkillResponse.class);

    /**
     * Creates and returns a response intended to ask to the user. After the ask response is
     * read to the user, the user can respond and continue to interact with the skill. The session
     * does not immediately end after the ask response.
     *
     * @param outputSpeechText output speech content for the ask voice response
     * @param rePromptText  This speech text is played if the user does
     *                 not reply to the question or replies with something that is not understood.
     *@param card Display card to be shown at client side.
     * @return SpeechletResponse spoken response for the given input
     */
    public static SpeechletResponse askResponse(String outputSpeechText, String rePromptText, SimpleCard card) {
        log.info("OutputSpeechText askResponse : < " + outputSpeechText + ">");
        SsmlOutputSpeech outputSpeech = new SsmlOutputSpeech();
        String speechText = String.format(Constants.SPEAK_TAGS, outputSpeechText);
        outputSpeech.setSsml(speechText);
        Reprompt rePrompt = getRePrompt(rePromptText);
        return SpeechletResponse.newAskResponse(outputSpeech, rePrompt, card);
    }

    /**
     * Creates and returns a response intended to tell the user.
     * After the specified output is read to the user, the session ends.
     *
     * @param outputSpeechText output speech content for the tell voice response.
     * @param card Display card to be shown at client side.
     * @return SpeechletResponse spoken response for the given input.
     */
    public static SpeechletResponse tellResponse(String outputSpeechText, SimpleCard card) {
        log.info("OutputSpeechText tellResponse: < " + outputSpeechText + ">");
        SsmlOutputSpeech outputSpeech = new SsmlOutputSpeech();
        String speechText = String.format(Constants.SPEAK_TAGS, outputSpeechText);
        outputSpeech.setSsml(speechText);
        return SpeechletResponse.newTellResponse(outputSpeech, card);
    }

    /**
     * @param rePrompt Reprompt speech text. This is played if the user does
     *                 not reply to the question or replies with something that is not understood.
     * @return Reprompt speech
     */
    private static Reprompt getRePrompt(String rePrompt) {
        Reprompt reprompt = new Reprompt();
        SsmlOutputSpeech rePromptOutputSpeech = new SsmlOutputSpeech();
        String rePromptText = String.format(Constants.SPEAK_TAGS, rePrompt);
        //PlainTextOutputSpeech rePromptSpeech = new PlainTextOutputSpeech();
        rePromptOutputSpeech.setSsml(rePromptText);
        reprompt.setOutputSpeech(rePromptOutputSpeech);
        return reprompt;
    }

    /**
     * @return
     */
    public static Reprompt commonRePrompt() {
        String rePromptText = "Sorry I didn't get that can you say that again?";
        Reprompt reprompt = new Reprompt();
        PlainTextOutputSpeech rePromptSpeech = new PlainTextOutputSpeech();
        rePromptSpeech.setText(rePromptText);
        reprompt.setOutputSpeech(rePromptSpeech);
        return reprompt;
    }


    public static SpeechletResponse newAskResponse(String stringOutput, Reprompt repromptText, SimpleCard cardData) {
        log.info("Speechtext : < " + stringOutput + ">");
        SsmlOutputSpeech outputSpeech = null;
        outputSpeech = new SsmlOutputSpeech();
        String speechText = String.format(Constants.SPEAK_TAGS, stringOutput);
        outputSpeech.setSsml(speechText);
        return SpeechletResponse.newAskResponse(outputSpeech, repromptText, cardData);
    }

    public static SpeechletResponse newAskResponsewithEndSession(String stringOutput, Reprompt repromptText, SimpleCard cardData) {
        log.info("Speechtext : < " + stringOutput + ">");
        SsmlOutputSpeech outputSpeech = null;
        outputSpeech = new SsmlOutputSpeech();
        String speechText = String.format(Constants.SPEAK_TAGS, stringOutput);
        outputSpeech.setSsml(speechText);
        SpeechletResponse response = SpeechletResponse.newAskResponse(outputSpeech, repromptText, cardData);
        response.setShouldEndSession(true);
        return response;
    }

    public static SimpleCard displayCard(String data) {
        SimpleCard cardData = new SimpleCard();
        cardData.setTitle(Constants.CARD_TITLE);
        cardData.setContent(data);
        return cardData;
    }

    /**
     * @param repromptText
     * @return
     */
    public static Reprompt repromptData(String repromptText) {
        Reprompt reprompt = new Reprompt();
        PlainTextOutputSpeech repromptSpeech = new PlainTextOutputSpeech();
        repromptSpeech.setText(repromptText);
        reprompt.setOutputSpeech(repromptSpeech);
        return reprompt;
    }

    /**
     * @return
     */
    public static Reprompt commonReprompt() {
        String repromptText = "Can you say that again?";
        Reprompt reprompt = new Reprompt();
        PlainTextOutputSpeech repromptSpeech = new PlainTextOutputSpeech();
        repromptSpeech.setText(repromptText);
        reprompt.setOutputSpeech(repromptSpeech);
        return reprompt;
    }
}