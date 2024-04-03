package otus.appium.pages;

import com.codeborne.selenide.Selenide;

public abstract class AbsBasePage {

  public AbsBasePage open() {
    Selenide.open();
    return this;
  }
}
