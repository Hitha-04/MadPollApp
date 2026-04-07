package com.example.madpollapp;

import android.content.Context;
import android.content.SharedPreferences;

// HITHASHREE's file — handles all data storage
public class PollManager {
    private static final String PREFS = "poll_prefs";

    public static void savePoll(Context ctx, String question, String optA, String optB) {
        SharedPreferences.Editor ed = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit();
        ed.putString("question", question);
        ed.putString("optA", optA);
        ed.putString("optB", optB);
        ed.putInt("votesA", 0);
        ed.putInt("votesB", 0);
        ed.apply();
    }

    public static String[] getPoll(Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        return new String[]{
                sp.getString("question", null),
                sp.getString("optA", null),
                sp.getString("optB", null)
        };
    }

    public static int[] getVotes(Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        return new int[]{sp.getInt("votesA", 0), sp.getInt("votesB", 0)};
    }

    public static void incrementVote(Context ctx, String option) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        if (option.equals("A")) ed.putInt("votesA", sp.getInt("votesA", 0) + 1);
        else ed.putInt("votesB", sp.getInt("votesB", 0) + 1);
        ed.apply();
    }

    public static void resetPoll(Context ctx) {
        ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().clear().apply();
    }

    public static boolean pollExists(Context ctx) {
        return ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                .getString("question", null) != null;
    }
}
