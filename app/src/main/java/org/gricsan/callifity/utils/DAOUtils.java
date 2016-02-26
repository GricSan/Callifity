package org.gricsan.callifity.utils;


public class DAOUtils {

    private static DAOUtils mDaoUtils;

    private DAOUtils() {
        mDaoUtils = new DAOUtils();
    }

    public static synchronized DAOUtils getInstance() {
        if (mDaoUtils == null) {
            mDaoUtils = new DAOUtils();
        }
        return mDaoUtils;
    }

}
