package info.tomfi.tutorials.mailapp.engine;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

import info.tomfi.tutorials.mailapp.core.Mail;
import info.tomfi.tutorials.mailapp.core.MailEngine;
import info.tomfi.tutorials.mailapp.core.MailService;
import java.util.List;

public final class LooseMailEngine implements MailEngine {
  private final MailService gmailService;
  private final MailService microsoftService;

  public LooseMailEngine(final MailService setGmailService, final MailService setMicrosoftService) {
    gmailService = setGmailService;
    microsoftService = setMicrosoftService;
  }

  @Override
  public List<Mail> getAllMail() {
    return concat(
            gmailService.getMail().stream(),
            microsoftService.getMail().stream())
        .collect(toList());
  }
}
