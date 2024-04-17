package otus.appium.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;
import static otus.appium.common.Constants.EXPLICIT_WAIT;
import static otus.appium.common.Constants.MAX_EXPLICIT_WAIT;

import com.google.inject.Inject;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;

public class ChatStep {

  private ChatPage chatPage;

  @Inject
  public ChatStep(ChatPage chatPage) {
    this.chatPage = chatPage;
  }

  //Проверяем отображение первого слайда
  @Step("Проверяем отображение первого слайда")
  public ChatStep checkOneSlide() {
    chatPage
        .getTextOneSlide()
        .shouldBe(visible.because("Текст на первом слайде не отобразился"), MAX_EXPLICIT_WAIT);
    chatPage
        .getNextText()
        .shouldBe(visible.because("Кнопка next не отобразилась"), EXPLICIT_WAIT)
        .click();
    chatPage
        .getTextOneSlide()
        .shouldNotBe(visible.because("Текст на первом слайде не скрылся"));
    return this;
  }

  //проверяем отображение второго слайда
  @Step("Проверяем отображение второго слайда")
  public ChatStep checkTwoSlide() {
    chatPage
        .getNextTextTwoSlide()
        .shouldBe(visible.because("Текст на втором слайде не отобразился"));
    chatPage
        .getNextText()
        .shouldBe(visible.because("Кнопка next не отобразилась"))
        .click();
    chatPage
        .getNextTextTwoSlide()
        .shouldNotBe(visible.because("Текст на втором слайде не скрылся"));
    return this;
  }

  //проверяем отображение третьего слайда
  @Step("Проверяем отображение третьего слайда")
  public ChatStep checkTreeSlide() {
    chatPage
        .getTextThreeSlide()
        .shouldBe(visible.because("Текст на третьем слайде не отобразился"));
    chatPage
        .getSkipLink()
        .shouldBe(visible.because("Кнопка skip не отобразилась"))
        .click();

    Alert alert = switchTo().alert(); //появляется alert при переходе к чату, эксептим его
    alert.accept();
    return this;
  }

  //проверяем отображение функционала открытого экрана с чатом
  @Step("Проверяем отображение функционала открытого экрана с чатом")
  public ChatStep checkVisibilityChat() {
    chatPage
        .getMessageWelcome()
        .shouldBe(visible.because("Приветственное сообщение в чате не отобразилось"), EXPLICIT_WAIT);
    chatPage
        .getEditText()
        .shouldBe(visible.because("Поле для ввода сообщения не отобразилось"));
    return this;
  }

  public ChatStep visibleSlide() {
    checkOneSlide();
    checkTwoSlide();
    checkTreeSlide();
    checkVisibilityChat();
    return this;
  }

  //Проверяем отображение экрана с упражнениями и стартуем упражнение
  public ChatStep checkWidgetExercise() {
    chatPage
        .getWidgetExercise()
        .shouldBe(visible.because("Виджет Exercise не отобразился в шапке"))
        .click();
    chatPage
        .getTextWidgetExercise()
        .shouldBe(text("Learn 5 new words today")
            .because("Текст на экране Exercise не отобразился и не соответствует 'Learn 5 new words today'"));
    chatPage
        .getButtonStart()
        .shouldBe(visible.because("Кнопка Start на экране Exercise не отобразилась"))
        .click();
    chatPage
        .getButtonStart()
        .shouldNotBe(visible.because("Кнопка Start на экране Exercise не скрылась"), EXPLICIT_WAIT);
    return this;
  }

  //проверяем отображение сообщения после клика на кнопку start и отображение сообщения с первым словом и вариантами ответов
  public ChatStep checkWelcomeMessage() {
    chatPage
        .getStartMessage()
        .shouldBe(visible.because("Стартовое сообщение не отобразилось"));
    chatPage
        .getBlockMessageOneWords()
        .shouldBe(visible.because("Блок с первым словом и блоком с вариантами ответов не отобразился"));
    chatPage
        .getButtonGotIt()
        .shouldBe(visible.because("Кнопка с вариантом ответа 'Got it' не отобразилась"));
    chatPage
        .getButtonIKnow()
        .shouldBe(visible.because("Кнопка с вариантом ответа 'I known this word' не отобразилась"));
    chatPage
        .getButtonExplain()
        .shouldBe(visible.because("Кнопка с вариантом ответа 'Explain' не отобразилась"));
    return this;
  }

  //проверяем экран по грамматике и стартуем упражнение
  public ChatStep checkStartGrammar() {
    chatPage
        .getWidgetGrammar()
        .shouldBe(visible.because("Виджет с грамматикой не отобразился"))
        .click();
    chatPage
        .getGrammarMachMany()
        .shouldBe(visible.because("Упражнение по грамматике 'Mach-Many' не отобразилось"));
    chatPage
        .getButtonGrammarStart()
        .shouldBe(visible.because("Кнопка 'Start' старт не отобразилась на экране по грамматике"))
        .click();
    chatPage
        .getButtonGrammarStart()
        .shouldNotBe(visible.because("Кнопка 'Start' старт не скрылась на экране по грамматике"), EXPLICIT_WAIT);
    return this;
  }

  //проверяем, что упражнение запущено
  public ChatStep checkStartMessageGrammar() {
    chatPage
        .getMessageStartGrammar()
        .shouldBe(visible.because("Сообщение с запуском упражнения не отобразилось"));
    chatPage
        .getMessageSureGrammar()
        .shouldBe(visible.because("Сообщение о начале упражнения не отобразилось"));
    return this;
  }

  //проверяем что появятся варианты ответов
  public ChatStep checkOptionGrammar() {
    chatPage
        .getSendTextContent()
        .shouldBe(visible.because("Поле для ввода сообщения не отобразилось"))
        .sendKeys("Yes");
    chatPage.getSendButton().click();
    chatPage
        .getCheckValueText()
        .shouldBe(visible.because("Отправленное сообщение 'Yes' не отобразилось"));
    chatPage
        .getButtonMany()
        .shouldBe(visible.because("Кнопка с вариантом ответа 'Many' не отобразилась"));
    chatPage
        .getButtonMuch()
        .shouldBe(visible.because("Кнопка с вариантом ответа 'Much' не отобразилась"));
    return this;
  }

  //берем первый в списке недоступный курс и проверяем, что у него есть кнопка Get Premium
  public ChatStep checkUnavailableLesson() {
    chatPage
        .getWidgetGrammar()
        .shouldBe(visible.because("Виджет с грамматикой не отобразился"))
        .click();
    chatPage
        .getButtonGetPremium()
        .shouldBe(visible.because("Кнопка 'Get Premium' у первого недоступного курса не отобразилась"))
        .click();
    chatPage
        .getButtonGetPremium()
        .shouldNotBe(visible.because("Кнопка 'Get Premium' у первого недоступного курса не скрылась"), EXPLICIT_WAIT);
    chatPage
        .getTextBarUpgrade()
        .shouldBe(visible.because("Текст 'Upgrade To Pro' не отобразился"));
    return this;
  }
}
