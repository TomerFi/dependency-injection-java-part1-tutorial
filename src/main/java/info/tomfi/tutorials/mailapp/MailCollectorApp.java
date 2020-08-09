package info.tomfi.tutorials.mailapp;

import com.google.common.base.Joiner;
import info.tomfi.tutorials.mailapp.core.MailEngine;
import info.tomfi.tutorials.mailapp.core.service.GmailService;
import info.tomfi.tutorials.mailapp.core.service.MicrosoftService;
import info.tomfi.tutorials.mailapp.engine.RobustMailEngine;
import java.util.Set;

public final class MailCollectorApp {
  private MailEngine engine;

  public MailCollectorApp(final MailEngine setEngine) {
    engine = setEngine;
  }

  public String getMail() {
    var ret = "No mail found.";
    if (!engine.getAllMail().isEmpty()) {
      ret = Joiner.on(System.lineSeparator()).join(engine.getAllMail());
    }
    return ret;
  }

  public static void main(final String... args) {
    var gmailService = new GmailService();
    var microsoftService = new MicrosoftService();

    var engine = new RobustMailEngine(Set.of(gmailService, microsoftService));

    var app = new MailCollectorApp(engine);

    System.out.println(app.getMail());
  }
}
