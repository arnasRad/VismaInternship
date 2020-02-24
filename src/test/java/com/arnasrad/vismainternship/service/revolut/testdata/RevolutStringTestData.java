package com.arnasrad.vismainternship.service.revolut.testdata;

public class RevolutStringTestData {

    public static String getAccountsString() {

        return "[" +
                "    {" +
                "        \"id\": \"5f47cde3-05fa-44b1-959a-2c60447a3094\"," +
                "        \"name\": \"Main\"," +
                "        \"balance\": 28577.39," +
                "        \"currency\": \"GBP\"," +
                "        \"state\": \"active\"," +
                "        \"public\": true," +
                "        \"created_at\": \"2020-02-04T09:19:23.465+00:00\"," +
                "        \"updated_at\": \"2020-02-18T06:14:04.640+00:00\"" +
                "    }," +
                "    {" +
                "        \"id\": \"65462d79-2613-4f5e-97fd-7c7d1572d4bf\"," +
                "        \"name\": \"Business trips\"," +
                "        \"balance\": 14700.0," +
                "        \"currency\": \"USD\"," +
                "        \"state\": \"active\"," +
                "        \"public\": true," +
                "        \"created_at\": \"2020-02-04T09:19:23.465+00:00\"," +
                "        \"updated_at\": \"2020-02-04T09:19:23.549+00:00\"" +
                "    }," +
                "    {" +
                "        \"id\": \"8bed66e7-db72-4096-be39-58460375171a\"," +
                "        \"name\": \"Payments\"," +
                "        \"balance\": 5300.0," +
                "        \"currency\": \"AUD\"," +
                "        \"state\": \"active\"," +
                "        \"public\": false," +
                "        \"created_at\": \"2020-02-04T09:19:23.540+00:00\"," +
                "        \"updated_at\": \"2020-02-04T09:19:23.540+00:00\"" +
                "    }," +
                "    {" +
                "        \"id\": \"14949f04-d50a-437f-ac41-a1cc45bbf721\"," +
                "        \"name\": \"European suppliers\"," +
                "        \"balance\": 3445.0," +
                "        \"currency\": \"EUR\"," +
                "        \"state\": \"active\"," +
                "        \"public\": true," +
                "        \"created_at\": \"2020-02-04T09:19:23.465+00:00\"," +
                "        \"updated_at\": \"2020-02-04T09:23:50.927+00:00\"" +
                "    }" +
                "]";
    }

    public static String getCounterpartyString() {

        return "{" +
                "    \"id\": \"f318277a-45bd-49ad-9c95-6c326a4b3da4\"," +
                "    \"name\": \"John Smith\"," +
                "    \"phone\": \"+4412345678908\"," +
                "    \"accounts\": [" +
                "        {" +
                "            \"id\": \"7bbc1f04-ffd0-4112-ba74-6aaedbaa9b44\"," +
                "            \"currency\": \"GBP\"," +
                "            \"type\": \"revolut\"" +
                "        }," +
                "        {" +
                "            \"id\": \"10d093a6-459a-4dbc-bf11-8bef44916176\"," +
                "            \"currency\": \"EUR\"," +
                "            \"type\": \"revolut\"" +
                "        }," +
                "        {" +
                "            \"id\": \"8e11da19-817f-487a-8988-55419666393e\"," +
                "            \"currency\": \"USD\"," +
                "            \"type\": \"revolut\"" +
                "        }" +
                "    ]," +
                "    \"state\": \"created\"," +
                "    \"country\": \"GB\"," +
                "    \"profile_type\": \"personal\"," +
                "    \"created_at\": \"2020-02-21T14:27:20.435+00:00\"," +
                "    \"updated_at\": \"2020-02-21T14:27:20.435+00:00\"" +
                "}";
    }

    public static String getAddCounterpartyRequestBodyString() {

        return "{" +
                "\"profile_type\":\"personal\"," +
                "\"name\":\"John Smith\"," +
                "\"phone\":\"+4412345678908\"" +
                "}";
    }

    public static String getCounterpartyListString() {

        return "[" +
                "    {" +
                "        \"id\": \"f318277a-45bd-49ad-9c95-6c326a4b3da4\"," +
                "        \"name\": \"John Smith\"," +
                "        \"phone\": \"+4412345678908\"," +
                "        \"accounts\": [" +
                "            {" +
                "                \"id\": \"7bbc1f04-ffd0-4112-ba74-6aaedbaa9b44\"," +
                "                \"currency\": \"GBP\"," +
                "                \"type\": \"revolut\"" +
                "            }," +
                "            {" +
                "                \"id\": \"10d093a6-459a-4dbc-bf11-8bef44916176\"," +
                "                \"currency\": \"EUR\"," +
                "                \"type\": \"revolut\"" +
                "            }," +
                "            {" +
                "                \"id\": \"8e11da19-817f-487a-8988-55419666393e\"," +
                "                \"currency\": \"USD\"," +
                "                \"type\": \"revolut\"" +
                "            }" +
                "        ]," +
                "        \"state\": \"created\"," +
                "        \"country\": \"GB\"," +
                "        \"profile_type\": \"personal\"," +
                "        \"created_at\": \"2020-02-21T14:27:20.435+00:00\"," +
                "        \"updated_at\": \"2020-02-21T14:27:20.435+00:00\"" +
                "    }," +
                "    {" +
                "        \"id\": \"15ce89d1-8425-4d34-a237-b4fa84844dac\"," +
                "        \"name\": \"Jane Doe\"," +
                "        \"phone\": \"+4412345678907\"," +
                "        \"accounts\": [" +
                "            {" +
                "                \"id\": \"c8034a96-9950-45a3-9e32-a3f2726a3255\"," +
                "                \"currency\": \"GBP\"," +
                "                \"type\": \"revolut\"" +
                "            }," +
                "            {" +
                "                \"id\": \"8e5fc0e7-83fb-4251-ae29-a7552cdc4694\"," +
                "                \"currency\": \"USD\"," +
                "                \"type\": \"revolut\"" +
                "            }," +
                "            {" +
                "                \"id\": \"0d4e9b51-8a7b-4332-af2c-ba1da0871145\"," +
                "                \"currency\": \"EUR\"," +
                "                \"type\": \"revolut\"" +
                "            }" +
                "        ]," +
                "        \"state\": \"created\"," +
                "        \"country\": \"GB\"," +
                "        \"profile_type\": \"personal\"," +
                "        \"created_at\": \"2020-02-17T10:27:59.078+00:00\"," +
                "        \"updated_at\": \"2020-02-17T10:27:59.078+00:00\"" +
                "    }," +
                "    {" +
                "        \"id\": \"bfa69762-bb1e-4e19-ac0e-78befed9cb0a\"," +
                "        \"name\": \"Jane Doe\"," +
                "        \"phone\": \"+4412345678906\"," +
                "        \"accounts\": [" +
                "            {" +
                "                \"id\": \"3c2aa3a2-4a1e-48bc-a539-02bd8e06ff59\"," +
                "                \"currency\": \"GBP\"," +
                "                \"type\": \"revolut\"" +
                "            }," +
                "            {" +
                "                \"id\": \"328aaf2b-570d-4acf-aa70-a649efdc10f4\"," +
                "                \"currency\": \"EUR\"," +
                "                \"type\": \"revolut\"" +
                "            }," +
                "            {" +
                "                \"id\": \"5d092ccb-df88-456b-a133-4f4caceac86c\"," +
                "                \"currency\": \"USD\"," +
                "                \"type\": \"revolut\"" +
                "            }" +
                "        ]," +
                "        \"state\": \"created\"," +
                "        \"country\": \"GB\"," +
                "        \"profile_type\": \"personal\"," +
                "        \"created_at\": \"2020-02-14T08:47:17.458+00:00\"," +
                "        \"updated_at\": \"2020-02-14T08:47:17.458+00:00\"" +
                "    }" +
                "]";
    }

    public static String getPaymentString() {

        return "{" +
                "    \"id\": \"6197e9be-672a-43d2-a2a4-e75f33849f11\"," +
                "    \"state\": \"completed\"," +
                "    \"completed_at\": \"2020-02-21T14:55:01.198+00:00\"," +
                "    \"created_at\": \"2020-02-21T14:55:01.197+00:00\"" +
                "}";
    }

    public static String getTransactionListString() {

        return "[" +
                "    {" +
                "        \"id\": \"6197e9be-672a-43d2-a2a4-e75f33849f11\"," +
                "        \"type\": \"transfer\"," +
                "        \"state\": \"completed\"," +
                "        \"reference\": \"Expenses funding\"," +
                "        \"legs\": [" +
                "            {" +
                "                \"amount\": -0.5," +
                "                \"currency\": \"GBP\"," +
                "                \"counterparty\": {" +
                "                    \"id\": \"b925e897-8b81-4187-a0a4-effb3397ad41\"," +
                "                    \"account_id\": \"fc036772-daba-4cf3-9f54-dfd112d201d0\"" +
                "                }," +
                "                \"description\": \"To John Smith\"," +
                "                \"balance\": 28562.89," +
                "                \"leg_id\": \"e3cc7768-ddc8-4bad-b2a6-126e27e84cdf\"," +
                "                \"account_id\": \"5f47cde3-05fa-44b1-959a-2c60447a3094\"" +
                "            }" +
                "        ]," +
                "        \"created_at\": \"2020-02-21T14:55:01.197+00:00\"," +
                "        \"completed_at\": \"2020-02-21T14:55:01.198+00:00\"," +
                "        \"request_id\": \"idUfeqR16LARbpnwmdahKF2cKTPpti\"," +
                "        \"updated_at\": \"2020-02-21T14:55:01.197+00:00\"" +
                "    }," +
                "    {" +
                "        \"id\": \"1f5cca5a-dc3f-469d-9f91-a6d6d4c7ab86\"," +
                "        \"type\": \"transfer\"," +
                "        \"state\": \"completed\"," +
                "        \"reference\": \"Expenses funding\"," +
                "        \"legs\": [" +
                "            {" +
                "                \"amount\": -0.5," +
                "                \"currency\": \"GBP\"," +
                "                \"counterparty\": {" +
                "                    \"id\": \"b925e897-8b81-4187-a0a4-effb3397ad41\"," +
                "                    \"account_id\": \"fc036772-daba-4cf3-9f54-dfd112d201d0\"" +
                "                }," +
                "                \"description\": \"To John Smith\"," +
                "                \"balance\": 28563.39," +
                "                \"leg_id\": \"7d2074ac-2a1a-4dac-a6c5-88a95bf8053e\"," +
                "                \"account_id\": \"5f47cde3-05fa-44b1-959a-2c60447a3094\"" +
                "            }" +
                "        ]," +
                "        \"created_at\": \"2020-02-21T12:51:24.035+00:00\"," +
                "        \"completed_at\": \"2020-02-21T12:51:24.035+00:00\"," +
                "        \"request_id\": \"rqPAagwCHPdh0Pg2sSW9XZUDZ\"," +
                "        \"updated_at\": \"2020-02-21T12:51:24.035+00:00\"" +
                "    }," +
                "    {" +
                "        \"id\": \"ad041ef8-5cf7-4483-ba8b-f500727fefe9\"," +
                "        \"type\": \"transfer\"," +
                "        \"state\": \"completed\"," +
                "        \"reference\": \"Expenses funding\"," +
                "        \"legs\": [" +
                "            {" +
                "                \"amount\": -0.5," +
                "                \"currency\": \"GBP\"," +
                "                \"counterparty\": {" +
                "                    \"id\": \"b925e897-8b81-4187-a0a4-effb3397ad41\"," +
                "                    \"account_id\": \"fc036772-daba-4cf3-9f54-dfd112d201d0\"" +
                "                }," +
                "                \"description\": \"To John Smith\"," +
                "                \"balance\": 28563.89," +
                "                \"leg_id\": \"3e47dbeb-f14c-4f0c-a368-7de9921aaa79\"," +
                "                \"account_id\": \"5f47cde3-05fa-44b1-959a-2c60447a3094\"" +
                "            }" +
                "        ]," +
                "        \"created_at\": \"2020-02-20T08:02:40.746+00:00\"," +
                "        \"completed_at\": \"2020-02-20T08:02:40.747+00:00\"," +
                "        \"request_id\": \"wjNkAgpxzTU2QOwU\"," +
                "        \"updated_at\": \"2020-02-20T08:02:40.746+00:00\"" +
                "    }," +
                "    {" +
                "        \"id\": \"5f5b6f81-d9ab-4aff-89d3-329ff2a43f27\"," +
                "        \"type\": \"transfer\"," +
                "        \"state\": \"completed\"," +
                "        \"reference\": \"Expenses funding\"," +
                "        \"legs\": [" +
                "            {" +
                "                \"amount\": -0.5," +
                "                \"currency\": \"GBP\"," +
                "                \"counterparty\": {" +
                "                    \"id\": \"b925e897-8b81-4187-a0a4-effb3397ad41\"," +
                "                    \"account_id\": \"fc036772-daba-4cf3-9f54-dfd112d201d0\"" +
                "                }," +
                "                \"description\": \"To John Smith\"," +
                "                \"balance\": 28564.39," +
                "                \"leg_id\": \"fdd0145b-f13a-47c6-b935-68917fbed41d\"," +
                "                \"account_id\": \"5f47cde3-05fa-44b1-959a-2c60447a3094\"" +
                "            }" +
                "        ]," +
                "        \"created_at\": \"2020-02-20T07:43:02.153+00:00\"," +
                "        \"completed_at\": \"2020-02-20T07:43:02.154+00:00\"," +
                "        \"request_id\": \"gBzG183AqRHga7QKTp6RyRhNcJ2cNOyX\"," +
                "        \"updated_at\": \"2020-02-20T07:43:02.153+00:00\"" +
                "    }" +
                "]";
    }

    public static String getTransactionString() {
        return "{" +
                "    \"id\": \"1198f556-f6f4-44c5-a9d4-a15a40ef5234\"," +
                "    \"type\": \"transfer\"," +
                "    \"state\": \"completed\"," +
                "    \"reference\": \"Expenses funding\"," +
                "    \"legs\": [" +
                "        {" +
                "            \"amount\": -0.5," +
                "            \"currency\": \"GBP\"," +
                "            \"counterparty\": {" +
                "                \"id\": \"b925e897-8b81-4187-a0a4-effb3397ad41\"," +
                "                \"account_id\": \"fc036772-daba-4cf3-9f54-dfd112d201d0\"" +
                "            }," +
                "            \"description\": \"To John Smith\"," +
                "            \"balance\": 28577.39," +
                "            \"leg_id\": \"3447c4dd-48d1-47cb-8fbe-9b30404508e7\"," +
                "            \"account_id\": \"5f47cde3-05fa-44b1-959a-2c60447a3094\"" +
                "        }" +
                "    ]," +
                "    \"created_at\": \"2020-02-18T06:14:04.607+00:00\"," +
                "    \"completed_at\": \"2020-02-18T06:14:04.636+00:00\"," +
                "    \"request_id\": \"Rn2zmMWZIn2r1WlntzQIH3TuniTb\"," +
                "    \"updated_at\": \"2020-02-18T06:14:04.607+00:00\"" +
                "}";
    }
}
