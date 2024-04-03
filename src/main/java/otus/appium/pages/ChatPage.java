package otus.appium.pages;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class ChatPage {

  private final SelenideElement nextText = $x("//android.widget.TextView[@text='Next']");
  private final SelenideElement textOneSlide = $x("//android.widget.TextView[@text=\"Chat to improve your English\"]");
  private final SelenideElement nextTextTwoSlide = $x("//android.widget.TextView[@text='Learn new words and grammar']");
  private final SelenideElement textThreeSlide = $x("//android.widget.TextView[@text=\"7 days FREE\"]");
  private final SelenideElement skipLink = $x("//android.widget.TextView[@text=\"Skip >\"]");
  private final SelenideElement messageWelcome = $x("//android.widget.TextView[contains(@text, 'Hello')]");
  private final SelenideElement editText = $x("//android.widget.EditText[@content-desc=\"Type a message...\"]");
  private final SelenideElement widgetExercise = $x("//android.widget.TextView[@text='Exercise']");
  private final SelenideElement textWidgetExercise =
      $x("//android.widget.TextView[@text=\"Learn 5 new words today\"]");
  private final SelenideElement buttonStart = $x("//android.widget.TextView[@text=\"Start\"]");
  private final SelenideElement startMessage = $x("//android.widget.ScrollView/android.view"
      + ".ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");
  private final SelenideElement blockMessageOneWords = $x("//android.widget.ScrollView/android.view"
      + ".ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
  private final SelenideElement buttonGotIt = $x("//android.widget.TextView[contains(@text, \"Got it\")]");
  private final SelenideElement buttonIKnow = $x("//android.widget.TextView[contains(@text, \"I know this word\")]");
  private final SelenideElement buttonExplain = $x("//android.widget.TextView[contains(@text, \"Explain\")]");
  private final SelenideElement messageExplainSend = $x("//android.widget.ScrollView/android.view"
      + ".ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup");
  private final SelenideElement widgetGrammar = $x("//android.widget.TextView[@text=\"Grammar\"]");
  private final SelenideElement grammarMachMany = $x("//android.widget.TextView[@text=\"Much - Many\"]");
  private final SelenideElement buttonGrammarStart = $x("(//android.widget.TextView[@text=\"Start\"])[1]");
  private final SelenideElement messageStartGrammar = $x("//android.widget.ScrollView/android.view.ViewGroup/android"
      + ".view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android"
      + ".widget.TextView");
  private final SelenideElement messageSureGrammar = $x("//android.widget.TextView[@text=\"Sure\"]");
  private final SelenideElement sendTextContent = $x("//android.widget.EditText[@content-desc=\"Type a message...\"]");
  private final SelenideElement checkValueText = $x("//android.widget.TextView[@text=\"Yes \"]");
  private final SelenideElement buttonMany = $x("//android.widget.TextView[@text=\"many\"]");
  private final SelenideElement buttonMuch = $x("//android.widget.TextView[@text=\"much\"]");
  private final SelenideElement buttonGetPremium = $x("(//android.widget.TextView[@text=\"GET PREMIUM\"])[1]");
  private final SelenideElement textBarUpgrade = $x("//android.widget.TextView[@text=\"Upgrade To Pro\"]");
  private final SelenideElement sendButton = $x("//android.widget.TextView[@text=\"Send\"]");
}
