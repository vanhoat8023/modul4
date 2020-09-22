package service;

import model.Mailbox;

import java.util.List;

public interface MailboxService {
    Mailbox findAll();

    void save(Mailbox mailbox);

    Mailbox findById(int id);

    void update(int id, Mailbox mailbox);

    void remove(int id);
}
