package com.fp.decoration;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public class Camera {
    private Function<Color, Color> filter;

    public Camera(){
        setFilters();
    }

    public Color capture(final Color input){
        final Color processedColor = filter.apply(input);
        return processedColor;
    }

    public void setFilters(final Function<Color,Color>... filters){
        filter = Stream.of(filters)
                .reduce((filter,next)->filter.compose(next))
                .orElse(color -> color);
    }

    public static void main(String[] args) {
        final Camera camera = new Camera();
        final Consumer<String> printCaptured = (filterInfo) ->
                System.out.println(String.format("With %s: %s", filterInfo,
                        camera.capture(new Color(200, 100, 200))));
        printCaptured.accept("No Filter");

        camera.setFilters(Color::brighter);
        printCaptured.accept("Brighter Filter");

        camera.setFilters(Color::brighter,Color::darker);
        printCaptured.accept("Multiple Filters");

    }
}
