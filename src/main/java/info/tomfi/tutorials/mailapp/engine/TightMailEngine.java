package info.tomfi.tutorials.mailapp.engine;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

import info.tomfi.tutorials.mailapp.core.Mail;
import info.tomfi.tutorials.mailapp.core.MailEngine;
import info.tomfi.tutorials.mailapp.core.MailService;
import info.tomfi.tutorials.mailapp.core.service.GmailService;
import info.tomfi.tutorials.mailapp.core.service.MicrosoftService;
import java.util.List;

public final class TightMailEngine implements MailEngine {
  private final MailService gmailService;
  private final MailService microsoftService;

  public TightMailEngine() {
    gmailService = new GmailService();
    microsoftService = new MicrosoftService();
  }

  @Override
  public List<Mail> getAllMail() {
    return concat(gmailService.getMail().stream(), microsoftService.getMail().stream())
        .collect(toList());
  }
}
