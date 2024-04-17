package otus.appium.test;

import com.google.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import otus.appium.extension.AndroidExtension;
import otus.appium.pages.AbsBasePage;
import otus.appium.pages.ChatStep;

@ExtendWith({AndroidExtension.class})
public class ChatTwoTest extends AbsBasePage {

  @Inject
  private ChatStep chatStep;

  @Test
  @DisplayName("Нельзя запустить недоступный урок по грамматике")
  public void checkOptionExplain() {
    open();
    chatStep
        .visibleSlide()
        .checkUnavailableLesson();
  }

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
}
