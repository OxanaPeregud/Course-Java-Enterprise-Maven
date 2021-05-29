package com.peregud.observerpattern;

public class MeetupApplication {
    public static void main(String[] args) {

        MeetupDB meetupDB = new MeetupDB();
        MeetupData meetupData = new MeetupData();
        CurrentMeetupDisplay currentDisplay = new CurrentMeetupDisplay(meetupData);

        meetupData.setMeetup(
                meetupDB.getMeetupTime(1),
                meetupDB.getLocation(1),
                meetupDB.getTopic(1));

        MeetupDB.getUTIL().closeSession();
    }
}
