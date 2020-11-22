package models;

import cl.transbank.webpay.Webpay;
import cl.transbank.webpay.WebpayNormal;
import cl.transbank.webpay.configuration.Configuration;

public class bank {
        public WebpayNormal calltransaction () throws Exception{
            WebpayNormal transaction =
            new Webpay(Configuration.forTestingWebpayPlusNormal())
            .getNormalTransaction();
            return transaction;
    }
}
