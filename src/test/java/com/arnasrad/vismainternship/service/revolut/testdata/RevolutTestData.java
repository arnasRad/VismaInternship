package com.arnasrad.vismainternship.service.revolut.testdata;

import com.arnasrad.vismainternship.model.revolut.account.RevolutAccount;
import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RevolutTestData {

    public static List<RevolutAccount> getTestAccounts() throws ParseException {

        StdDateFormat formatter = new StdDateFormat().withColonInTimeZone(true);
        List<RevolutAccount> accountList = new ArrayList<>();

        accountList.add(new RevolutAccount("5f47cde3-05fa-44b1-959a-2c60447a3094", "Main", 28577.39, "GBP", "active",
                true, formatter.parse("2020-02-04T09:19:23.465+00:00"), formatter.parse("2020-02-18T06:14:04.640+00:00")));
        accountList.add(new RevolutAccount("65462d79-2613-4f5e-97fd-7c7d1572d4bf", "Business trips", 14700.0, "USD",
                "active", true, formatter.parse("2020-02-04T09:19:23.465+00:00"), formatter.parse("2020-02-04T09:19" +
                ":23.549+00:00")));
        accountList.add(new RevolutAccount("8bed66e7-db72-4096-be39-58460375171a", "Payments", 5300.0, "AUD",
                "active", false, formatter.parse("2020-02-04T09:19:23.540+00:00"), formatter.parse("2020-02-04T09:19:23.540+00:00")));
        accountList.add(new RevolutAccount("14949f04-d50a-437f-ac41-a1cc45bbf721",  "European suppliers", 3445.0,
                "EUR", "active",  true, formatter.parse("2020-02-04T09:19:23.465+00:00"), formatter.parse("2020-02" +
                "-04T09:23:50.927+00:00")));

        return accountList;
    }

    public static String getTestAccountsString() {

        return "[\n" +
                "    {\n" +
                "        \"id\": \"5f47cde3-05fa-44b1-959a-2c60447a3094\",\n" +
                "        \"name\": \"Main\",\n" +
                "        \"balance\": 28577.39,\n" +
                "        \"currency\": \"GBP\",\n" +
                "        \"state\": \"active\",\n" +
                "        \"public\": true,\n" +
                "        \"created_at\": \"2020-02-04T09:19:23.465+00:00\",\n" +
                "        \"updated_at\": \"2020-02-18T06:14:04.640+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"65462d79-2613-4f5e-97fd-7c7d1572d4bf\",\n" +
                "        \"name\": \"Business trips\",\n" +
                "        \"balance\": 14700.0,\n" +
                "        \"currency\": \"USD\",\n" +
                "        \"state\": \"active\",\n" +
                "        \"public\": true,\n" +
                "        \"created_at\": \"2020-02-04T09:19:23.465+00:00\",\n" +
                "        \"updated_at\": \"2020-02-04T09:19:23.549+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"8bed66e7-db72-4096-be39-58460375171a\",\n" +
                "        \"name\": \"Payments\",\n" +
                "        \"balance\": 5300.0,\n" +
                "        \"currency\": \"AUD\",\n" +
                "        \"state\": \"active\",\n" +
                "        \"public\": false,\n" +
                "        \"created_at\": \"2020-02-04T09:19:23.540+00:00\",\n" +
                "        \"updated_at\": \"2020-02-04T09:19:23.540+00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"14949f04-d50a-437f-ac41-a1cc45bbf721\",\n" +
                "        \"name\": \"European suppliers\",\n" +
                "        \"balance\": 3445.0,\n" +
                "        \"currency\": \"EUR\",\n" +
                "        \"state\": \"active\",\n" +
                "        \"public\": true,\n" +
                "        \"created_at\": \"2020-02-04T09:19:23.465+00:00\",\n" +
                "        \"updated_at\": \"2020-02-04T09:23:50.927+00:00\"\n" +
                "    }\n" +
                "]";
    }
}
