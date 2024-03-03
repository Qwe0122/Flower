package com.example.hello.utils;


import javafx.scene.image.Image;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondPageUtils {

    private static final Random random = new Random();

    public Image getRandomImage() throws URISyntaxException {
        List<Image> images = new ArrayList<>();
        images.add(new Image(SecondPageUtils.class.getResource("/photos/1.jpg").toURI().toString()));
        images.add(new Image(SecondPageUtils.class.getResource("/photos/2.jpg").toURI().toString()));
        images.add(new Image(SecondPageUtils.class.getResource("/photos/3.jpg").toURI().toString()));
        images.add(new Image(SecondPageUtils.class.getResource("/photos/4.jpg").toURI().toString()));
        images.add(new Image(SecondPageUtils.class.getResource("/photos/5.jpg").toURI().toString()));
        images.add(new Image(SecondPageUtils.class.getResource("/photos/6.jpg").toURI().toString()));
        images.add(new Image(SecondPageUtils.class.getResource("/photos/7.jpg").toURI().toString()));
        return images.get(random.nextInt(images.size()));
    }

    public String getRandomText() {
        String[] strings = {" С Днем цветов и красоты! \n" +
                " Пусть исполнятся мечты, \n" +
                "Пусть вас любят и лелеют \n" +
                " И теплом всегда согреют! ", "В женский день, 8 Марта,\n" +
                "В праздник счастья, красоты\n" +
                "Главным станет пусть подарком\n" +
                "Исполнение мечты!",
                "C праздником 8 Марта! Желаю, чтобы в душе круглый год цвела весна,\n" +
                        "а в жизни были только позитивные события,\n" +
                        "и улыбка стала самым прекрасным украшением жизни!",
                "Пусть весна согреет сердце\n" +
                        "Ласковым своим теплом,\n" +
                        "Принесет 8 Марта\n" +
                        "Счастье и удачу в дом!",
                "Пусть глаза сияют ярко\n" +
                        "От любви, тепла, подарков.\n" +
                        "Жизни — радостной, приятной!\n" +
                        "Поздравляю с 8 Марта! ",
                "Пусть сбываются мечты\n" +
                        "В день тепла и красоты,\n" +
                        "Принесет вам жизнь подарки.\n" +
                        "С Женским днем 8 Марта!",
                "Любви, тепла и красоты,\n" +
                        "Уюта, счастья, доброты.\n" +
                        "Букетов много, самых ярких.\n" +
                        "Слов и подарков. С 8 Марта!",
                "Вам желаем в день весенний\n" +
                        "Мы, без всяческих сомнений,\n" +
                        "Море самых нежных слов\n" +
                        "И прекраснейших цветов!",
                "Лишь нежного счастья, весны, настроения,\n" +
                        "Прекрасных улыбок, воодушевления,\n" +
                        "Эмоций чудесных, комфорта душевного\n" +
                        "И счастья желаю я Вам повседневного!"
        };
        return strings[random.nextInt(strings.length)];
    }
}
