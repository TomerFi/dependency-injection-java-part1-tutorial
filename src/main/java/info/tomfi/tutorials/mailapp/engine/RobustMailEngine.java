package info.tomfi.tutorials.mailapp.engine;

import static java.util.stream.Collectors.toList;

import info.tomfi.tutorials.mailapp.core.Mail;
import info.tomfi.tutorials.mailapp.core.MailEngine;
import info.tomfi.tutorials.mailapp.core.MailService;
import java.util.List;

public final class RobustMailEngine implements MailEngine {
  private final List<MailService> mailServices;

  public RobustMailEngine(final List<MailService> setMailSerices) {
    mailServices = setMailSerices;
  }

  @Override
  public List<Mail> getAllMail() {
    return mailServices.stream().map(MailService::getMail).flatMap(List::stream).collect(toList());
  }
}
