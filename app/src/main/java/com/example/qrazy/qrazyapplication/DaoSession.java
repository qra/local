package wapchief.com.collectiondemo.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import wapchief.com.collectiondemo.greendao.model.CarShop;
import wapchief.com.collectiondemo.greendao.model.Message;
import wapchief.com.collectiondemo.greendao.model.User;

import wapchief.com.collectiondemo.greendao.CarShopDao;
import wapchief.com.collectiondemo.greendao.MessageDao;
import wapchief.com.collectiondemo.greendao.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig carShopDaoConfig;
    private final DaoConfig messageDaoConfig;
    private final DaoConfig userDaoConfig;

    private final CarShopDao carShopDao;
    private final MessageDao messageDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        carShopDaoConfig = daoConfigMap.get(CarShopDao.class).clone();
        carShopDaoConfig.initIdentityScope(type);

        messageDaoConfig = daoConfigMap.get(MessageDao.class).clone();
        messageDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        carShopDao = new CarShopDao(carShopDaoConfig, this);
        messageDao = new MessageDao(messageDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(CarShop.class, carShopDao);
        registerDao(Message.class, messageDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        carShopDaoConfig.clearIdentityScope();
        messageDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public CarShopDao getCarShopDao() {
        return carShopDao;
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}