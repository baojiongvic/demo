package com.vic.practice.instance;

/**
 * 源程序名称：BankTesl <br>
 * 源程序包名：com.vic.practice.instance <br>
 * 系统名称：practice <br>
 * 开发时间：2020/9/14 11:37 下午 <br>
 *
 * @author baojiong20176 <br>
 * <br>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 */
public class BankTesl {
}

class Bank {

    private static volatile Bank instance;

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

    private Bank() {
    }
}
