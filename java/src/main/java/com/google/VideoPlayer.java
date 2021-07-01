package com.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class VideoPlayer {
  private final VideoLibrary videoLibrary;
    private Video currentVideo = null;
    private boolean currentVideoPlaying = false;

    public VideoPlayer() {
        this.videoLibrary = new VideoLibrary();
    }

    public void numberOfVideos() {
        System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
    }

    public void showAllVideos() {
        System.out.println("Here's a list of all available videos:");

        List<String> names = new ArrayList<>();
        for(Video video: videoLibrary.getVideos()){
            names.add(video.getVideoId());
        }
        Collections.sort(names);

        for(String name: names){
            Video video = videoLibrary.getVideo(name);
            System.out.print(video.getTitle()
                    + " (" +
                    video.getVideoId()
                    + ") ");
            System.out.print("[");
            int counter = 1;

            for (String tag: video.getTags()) {
                if(counter == video.getTags().size()){
                    System.out.print(tag);
                }else{
                    System.out.print(tag+" ");
                    counter++;
                }
            }
            System.out.print("]\n");
        }
    }

    public void playVideo(String videoId) {

        Video video = videoLibrary.getVideo(videoId);
        if(!(video == null)){
            if(currentVideo != null){
                stopVideo();
            }
            currentVideo = video;
            currentVideoPlaying = true;
            System.out.println("Playing video: "+ currentVideo.getTitle());
        }else{
            System.out.println("Cannot play video: Video does not exist");
        }
    }

    public void stopVideo() {
        if(currentVideo != null){
            currentVideoPlaying = false;
            System.out.println("Stopping video: "+currentVideo.getTitle());
            currentVideo = null;
        }else{
            System.out.println("Cannot stop video: No video is currently playing");
        }
    }

    public void playRandomVideo() {
        if(currentVideoPlaying){stopVideo();}
        Random random = new Random();
        int randomIndex = random.nextInt(videoLibrary.getVideos().size() - 1);
        Video randomVideo = videoLibrary.getVideos().get(randomIndex);
        playVideo(randomVideo.getVideoId());
    }

    public void pauseVideo() {
        if(currentVideo != null){
            if(currentVideoPlaying == true){
                currentVideoPlaying = false;
                System.out.println("Pausing video: "+currentVideo.getTitle());
            }else{
                System.out.println("Video already paused: "+currentVideo.getTitle());
            }
        }else{
            System.out.println("Cannot pause video: No video is currently playing");
        }
    }

    public void continueVideo() {
        if(currentVideo == null){
            System.out.print("Cannot continue video: No video is currently playing");
        }else{
            if(currentVideoPlaying == true){
                System.out.print("Cannot continue video: Video is not paused");
            }else{
                currentVideoPlaying = true;
                System.out.print("Continuing video: "+currentVideo.getTitle());
            }

        }
    }

    public void showPlaying() {

        if(currentVideo != null){

            if(currentVideoPlaying){
                System.out.print("Currently playing: "+currentVideo.getTitle()
                        + " (" +
                        currentVideo.getVideoId()
                        + ") ");
                System.out.print("[");
                int counter = 1;

                for (String tag: currentVideo.getTags()) {
                    if(counter == currentVideo.getTags().size()){
                        System.out.print(tag);
                    }else{
                        System.out.print(tag+" ");
                        counter++;
                    }
                }
                System.out.print("]");
            }else{
                System.out.print("Currently playing: "+currentVideo.getTitle()
                        + " (" +
                        currentVideo.getVideoId()
                        + ") ");
                System.out.print("[");
                int counter = 1;

                for (String tag: currentVideo.getTags()) {
                    if(counter == currentVideo.getTags().size()){
                        System.out.print(tag);
                    }else{
                        System.out.print(tag+" ");
                        counter++;
                    }
                }
                System.out.print("] - PAUSED");
            }
        }else{
            System.out.println("No video is currently playing!");
        }
    }


    /////////////////--------------------------------------------------//////////////////////////

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }


  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

    /////////////////--------------------------------------------------//////////////////////////

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

    /////////////////--------------------------------------------------//////////////////////////

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}