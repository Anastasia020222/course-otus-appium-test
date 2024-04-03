package otus.appium.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import otus.appium.pages.ChatPage;
import otus.appium.pages.ChatStep;

public class GuiceModule extends AbstractModule {

  @Provides
  @Singleton
  public ChatPage getChatPage() {
    return new ChatPage();
  }

  @Provides
  @Singleton
  public ChatStep getChatStep(ChatPage chatPage) {
    return new ChatStep(chatPage);
  }
}
