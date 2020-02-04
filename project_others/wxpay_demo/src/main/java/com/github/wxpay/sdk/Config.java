package com.github.wxpay.sdk;

import java.io.InputStream;

/**
 * @author bingai
 * @create 2020-01-31 1:06
 */
public class Config extends WXPayConfig {
    String getAppID() {
        return "wx8397f8696b538317";
    }

    String getMchID() {
        return "1473426802";
    }

    String getKey() {
        return "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb";
    }

    InputStream getCertStream() {
        return null;
    }

    IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            public void report(String s, long l, Exception e) {

            }

            public DomainInfo getDomain(WXPayConfig wxPayConfig) {
                return new DomainInfo("api.mch.weixin.qq.com",true);
            }
        };
    }
}
