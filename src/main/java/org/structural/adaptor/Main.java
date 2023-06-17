package org.structural.adaptor;

interface MediaPlayer {
         void play(String audioType, String fileName);
         }

interface AdvancedMediaPlayer {
   void playVlc(String fileName);
   void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {
   @Override
   public void playVlc(String fileName) {
      System.out.println("Playing VLC file: " + fileName);
   }

   @Override
   public void playMp4(String fileName) {
      // Do nothing
   }
}

class Mp4Player implements AdvancedMediaPlayer {
   @Override
   public void playVlc(String fileName) {
      // Do nothing
   }

   @Override
   public void playMp4(String fileName) {
      System.out.println("Playing MP4 file: " + fileName);
   }
}

class MediaAdapter implements MediaPlayer {
   private AdvancedMediaPlayer advancedMediaPlayer;

   public MediaAdapter(String audioType) {
      if (audioType.equalsIgnoreCase("vlc")) {
         advancedMediaPlayer = new VlcPlayer();
      } else if (audioType.equalsIgnoreCase("mp4")) {
         advancedMediaPlayer = new Mp4Player();
      }
   }

   @Override
   public void play(String audioType, String fileName) {
      if (audioType.equalsIgnoreCase("vlc")) {
         advancedMediaPlayer.playVlc(fileName);
      } else if (audioType.equalsIgnoreCase("mp4")) {
         advancedMediaPlayer.playMp4(fileName);
      }
   }
}

class AudioPlayer implements MediaPlayer {
   private MediaAdapter mediaAdapter;

   @Override
   public void play(String audioType, String fileName) {
      if (audioType.equalsIgnoreCase("mp3")) {
         System.out.println("Playing MP3 file: " + fileName);
      } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
         mediaAdapter = new MediaAdapter(audioType);
         mediaAdapter.play(audioType, fileName);
      } else {
         System.out.println("Invalid media type: " + audioType);
      }
   }
}

class Main {
   public static void main(String[] args) {
      AudioPlayer audioPlayer = new AudioPlayer();

      audioPlayer.play("mp3", "song.mp3");
      audioPlayer.play("vlc", "movie.vlc");
      audioPlayer.play("mp4", "video.mp4");
      audioPlayer.play("avi", "video.avi");
   }
}

