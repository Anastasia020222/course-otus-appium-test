package otus.appium.test;

import com.google.inject.Inject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import otus.appium.extension.AndroidExtension;
import otus.appium.pages.AbsBasePage;
import otus.appium.pages.ChatStep;

@ExtendWith({AndroidExtension.class})
public class ChatTest extends AbsBasePage {

  @Inject
  private ChatStep chatStep;

  @Test
  @DisplayName("Отображение приветственных слайдов")
  public void checkVisibleWelcomeSlideTest() {
    open();
    chatStep
        .checkOneSlide()
        .checkTwoSlide()
        .checkTreeSlide()
        .checkVisibilityChat();
  }

  @Test
  @DisplayName("Запуск упражнения 'Изучить пять слов'")
  public void checkStartExerciseTest() {
    open();
    chatStep
        .visibleSlide()
        .checkWidgetExercise()
        .checkWelcomeMessage();
  }

  @Test
  @DisplayName("Запуск занятия по грамматике")
  public void checkStartGrammarTest() {
    open();
    chatStep
        .visibleSlide()
        .checkStartGrammar()
        .checkStartMessageGrammar()
        .checkOptionGrammar();
  }

  @Test
  @DisplayName("Нельзя запустить недоступный урок по грамматике")
  public void checkOptionExplain() {
    open();
    chatStep
        .visibleSlide()
        .checkUnavailableLesson();
  }
}
