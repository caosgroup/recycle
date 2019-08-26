//package com.ares.recycle.config;
//
//public class ACMConfig {
//
//        // Properties/Switch
//        private static String config = "DefaultValue";
//
//        private static Properties acmProperties = new Properties();
//
//        public static void main(String[] args) {
//            try {
//
//                // Initialize configuration service and the console will retrieve the following parameters through the sample code. Input parameters include endpoint, namespace, accessKey, and secretKey(The secrectKey of ACM. Do not use the secrectKey of your Alibaba acount.).
//                Properties properties = new Properties();
//                properties.put("endpoint", "acm.aliyun.com");
//                properties.put("namespace", "e42d6450-43d4-4c67-ad99-0801baa5f8bd");
//                // Access ACM with instance RAM role: https://help.aliyun.com/document_detail/72013.html
//                // properties.put("ramRoleName", "$ramRoleName");
//                properties.put("accessKey", "d4037ed811104b8cb254135aa6cf24cb");
//                properties.put("secretKey", "tXyNzLIsU4ja5eR1XmQM5m6t+1Y=");
//
//                ConfigService.init(properties);
//                // Get configuration proactively
//                String content = ConfigService.getConfig("demo123434764321345765432", "DEFAULT_GROUP", 6000);
//                System.out.println(content);
//                // Add listener for the configuration during initialization, so that configuration changes will trigger callback notifications.
//                ConfigService.addListener("demo123434764321345765432", "DEFAULT_GROUP", new ConfigChangeListener() {
//                    public void receiveConfigInfo(String configInfo) {
//                        // When the configuration is updated, the callback function will send the new value to the user.
//                        // Note that you should not perform any block operations in the callback function. Otherwise the thread will be blocked.
//                        config = configInfo;
//                        System.out.println(configInfo);
//                    }
//                });
//
//                /**
//                 * If the configuration value is in the format of properties (key=value), you can use the following listener to configure multiple configuration items in one configuration.
//                 */
//
//                /**
//                 ConfigService.addListener("demo123434764321345765432", "DEFAULT_GROUP", new PropertiesListener() {
//
//                @Override
//                public void innerReceive(Properties properties) {
//                // TODO Auto-generated method stub
//                acmProperties = properties;
//                System.out.println(properties);
//                }
//                });
//
//                 **/
//
//            } catch (ConfigException e) {
//                e.printStackTrace();
//            }
//
//            // In this sample, the main thread does not exit, because the configuration subscription is the daemon thread, and it will exit if the main threads exits. The following code is not needed in real scenarios.
//            while (true) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        // Expose the configuration value with the GET interface
//        public static String getConfig() {
//            return config;
//        }
//
//        // Expose the configuration value with the GET interface
//        public static Object getPorpertiesValue(String key) {
//            if (acmProperties != null) {
//                return acmProperties.get(key);
//            }
//            return null;
//        }
//}
