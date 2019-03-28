package gui;

import java.awt.*;

public class User {
    //private final static Random random = new Random();
    // Ссылка на сессию, через которую можно отправлять сообщения на клиент
   // private ManagedReference<ClientSession> sessionRef;
    final String userId;
    final Point content;

    public User(String id, Point newGame) {
        this.userId = id;
        this.content = newGame;

    }

    //public void setSession(ClientSession session) {
     //   sessionRef = AppContext.getDataManager().createReference(session);
    //}

}
