package com.fp;

import java.util.function.Consumer;

public class FluentMailer {
    private FluentMailer(){}
    public FluentMailer from(final String address) {
        System.out.println("from Set.....");
        return this; }

    public FluentMailer to(final String address)   {
        System.out.println("to Set.....");
        return this; }

    public FluentMailer subject(final String line) {
        System.out.println("subject Set.....");
        return this; }

    public FluentMailer body(final String message) {
        System.out.println("body Set.....");
        return this; }

    public static void send(final Consumer<FluentMailer> block){
        final FluentMailer mailer = new FluentMailer();
        block.accept(mailer);
        System.out.println("Sending.....");
    }

    public static void main(String[] args) {
        FluentMailer.send(mailer -> mailer.from("abc@def.com")
                .subject("Hello")
                .body("How are you")
                .to("xyz@uv.com"));
    }
}
