package repository;

import model.Mailbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailboxRepositoryImpl implements MailboxRepository{

    @Override
    public Mailbox findAll() {
       return new Mailbox("English","25","enable spams filter",new String[]{"Thor king,asgard"});
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Object o) {

    }

    @Override
    public void remove(int id) {

    }
}
