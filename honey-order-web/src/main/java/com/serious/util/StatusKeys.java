package com.serious.util;

import java.util.ArrayList;
import java.util.List;

public enum StatusKeys {
    NEW(1, "Новый"),
    SENT(2, "Отправлен"),
    GET(3, "Получен"),
    PAID(4, "Оплачен"),
    ARCHIVE(0, "Архивный");

    private Integer state;
    private String text;

    StatusKeys(Integer state, String text) {
        this.state = state;
        this.text = text;
    }

    public Integer getState() {
        return state;
    }

    public String getText() {
        return text;
    }

    public static List<StatusKeys> getAllStatuses() {
        List<StatusKeys> list = new ArrayList<>();
        list.add(NEW);
        list.add(SENT);
        list.add(GET);
        list.add(PAID);
        list.add(ARCHIVE);
        return list;
    }

    public static String getTextOnInt(int state) {
        for (StatusKeys s: StatusKeys.values()) {
            if (s.getState() == state)
                return s.getText();
        }
        return "Неизвестный статус";
    }
}

