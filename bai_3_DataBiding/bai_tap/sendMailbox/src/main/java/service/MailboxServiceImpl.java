package service;

import model.Mailbox;
import repository.MailboxRepository;
import repository.MailboxRepositoryImpl;

public class MailboxServiceImpl implements MailboxService{
    MailboxRepository mailboxRepository = new MailboxRepositoryImpl();

    @Override
    public Mailbox findAll() {
        return mailboxRepository.findAll();
    }

    @Override
    public void save(Mailbox mailbox) {

    }

    @Override
    public Mailbox findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Mailbox mailbox) {

    }

    @Override
    public void remove(int id) {

    }
}
