package com.teachableapps.gradlebuilditbigger.javajokes;

import java.util.ArrayList;
import java.util.Random;

public class Joker {

    private Random randomGenerator;
    private ArrayList<String> jokelist;

    public Joker() {
        jokelist = new ArrayList<String>();
//        jokelist.clear();
        jokelist.add("Q: What goes up and down but does not move?\nA: Stairs");
        jokelist.add("Q: Where should a 500 pound alien go?\nA: On a diet");
        jokelist.add("Q: What did one toilet say to the other?\nA: You look a bit flushed.");
        jokelist.add("Q: Why did the picture go to jail?\nA: Because it was framed.");
        jokelist.add("Q: What did one wall say to the other wall? \nA: I'll meet you at the corner.");
        jokelist.add("Q: What did the paper say to the pencil?\nA: Write on!");
        jokelist.add("Q: What do you call a boy named Lee that no one talks to?\nA: Lonely");
        jokelist.add("Q: What gets wetter the more it dries? \nA: A towel.");
        jokelist.add("Q: Why do bicycles fall over?\nA: Because they are two-tired!");
        jokelist.add("Q: Why do dragons sleep during the day?\nA: So they can fight knights!");
        jokelist.add("Q: What did Cinderella say when her photos did not show up?\nA: Someday my prints will come!");
        jokelist.add("Q: Why was the broom late? \nA: It over swept!");
        jokelist.add("Q: What part of the car is the laziest?\nA: The wheels, because they are always tired!");
        jokelist.add("Q: What did the stamp say to the envelope? \nA: Stick with me and we will go places!");
        jokelist.add("Q: What is blue and goes ding dong?\nA: An Avon lady at the North Pole!");
        jokelist.add("Q: We're you long in the hospital?\nA: No, I was the same size I am now!");
        jokelist.add("Q: Why couldn't the pirate play cards? \nA: Because he was sitting on the deck!");
        jokelist.add("Q: What did the laundryman say to the impatient customer?\nA: Keep your shirt on!");
        jokelist.add("Q: What's the difference between a TV and a newspaper?\nA: Ever tried swatting a fly with a TV?");
        jokelist.add("Q: What did one elevator say to the other elevator? \nA: I think I'm coming down with something!");
        jokelist.add("Q: Why was the belt arrested?\nA: Because it held up some pants!");
        jokelist.add("Q: Why was everyone so tired on April 1st?\nA: They had just finished a March of 31 days.");
        jokelist.add("Q: Which hand is it better to write with?\nA: Neither, it's best to write with a pen!");
        jokelist.add("Q: Why can't your nose be 12 inches long? \nA: Because then it would be a foot!");
        jokelist.add("Q: What makes the calendar seem so popular?\nA: Because it has a lot of dates!");
        jokelist.add("Q: Why did Mickey Mouse take a trip into space?\nA: He wanted to find Pluto!");
        jokelist.add("Q: What is green and has yellow wheels?\nA: Grass…..I lied about the wheels!");
        jokelist.add("Q: What is it that even the most careful person overlooks?\nA: Her nose!");
        jokelist.add("Q: Did you hear about the robbery last night?\nA: Two clothes pins held up a pair of pants!");
        jokelist.add("Q: Why do you go to bed every night?\nA: Because the bed won't come to you!");
        jokelist.add("Q: Why did Billy go out with a prune?\nA: Because he couldn't find a date!");
        jokelist.add("Q: Why do eskimos do their laundry in Tide?\nA: Because it's too cold out-tide!");
        jokelist.add("Q: How do you cure a headache?\nA: Put your head through a window and the pane will just disappear!");
        jokelist.add("Q: What has four wheels and flies?\nA: A garbage truck!");
        jokelist.add("Q: What kind of car does Mickey Mouse's wife drive?\nA: A minnie van!");
        jokelist.add("Q: Why don't traffic lights ever go swimming?\nA: Because they take too long to change!");
        jokelist.add("Q: Why did the man run around his bed?\nA: To catch up on his sleep!");
        jokelist.add("Q: Why did the robber take a bath before he stole from the bank?\nA: He wanted to make a clean get away!");

        randomGenerator = new Random();
    }

    public String getJoke() {
        int index = randomGenerator.nextInt(jokelist.size());
        return jokelist.get(index);
    }
}
