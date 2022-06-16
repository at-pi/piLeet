class VideoSharingPlatform {
    
    class Video{
        String video;
        int likes;
        int dislikes;
        int views;
        public Video(String video){
            this.video = video;
        }
    }
    
    PriorityQueue<Integer> pq;
    Map<Integer, Video> map;
    
    public VideoSharingPlatform() {
        this.map = new HashMap<>();
        this.pq = new PriorityQueue<>((a,b) -> (a-b));
        for(int i=0; i<100000; i++){
            pq.add(i);
        }
    }
    
    public int upload(String video) {
        int videoId = pq.poll();
        Video videoObj = new Video(video);
        //System.out.println("UPLOAD created videoId - "+videoId+" created video - "+video);
        map.put(videoId, videoObj);
        return videoId;
    }
    
    public void remove(int videoId) {
        if(map.containsKey(videoId)){
            map.remove(videoId);
            //System.out.println("REMOVE removed videoId and added to head - "+videoId);
            pq.add(videoId);
        }
        else{
            //System.out.println("No videId found");
        }
    }
    
    public String watch(int videoId, int startMinute, int endMinute) {
        if(map.containsKey(videoId)){
            Video vidObj = map.get(videoId);
            vidObj.views++;
            int min = Math.min(endMinute, vidObj.video.length());
            if(min == vidObj.video.length()){
                //System.out.println("WATCH incresed views by 1 and video is - "+vidObj.video.substring(startMinute, min));
                return vidObj.video.substring(startMinute, min); 
            }
            else{
                //System.out.println("WATCH incresed views by 1 and video is - "+vidObj.video.substring(startMinute, min+1));
                return vidObj.video.substring(startMinute, min+1);
            }
            
            //return vidObj.video.substring(startMinute, Math.min(endMinute, vidObj.video.length()));
        }
        else{
            return "-1";
        }
    }
    
    public void like(int videoId) {
        if(map.containsKey(videoId)){
            Video vidObj = map.get(videoId);
            //System.out.println("increased likes on "+videoId+" by 1");
            vidObj.likes++;
        }
    }
    
    public void dislike(int videoId) {
        if(map.containsKey(videoId)){
            Video vidObj = map.get(videoId);
            //System.out.println("increased dislikes on "+videoId+" by 1");
            vidObj.dislikes++;
        }
    }
    
    public int[] getLikesAndDislikes(int videoId) {
        if(map.containsKey(videoId)){
            int[] ret = new int[2];
            Video vidObj = map.get(videoId);
            ret[0] = vidObj.likes;
            ret[1] = vidObj.dislikes;
            //System.out.println("likes dislike - "+ret);
            return ret;
        }
        else{
            return new int[]{-1};
        }
    }
    
    public int getViews(int videoId) {
        if(map.containsKey(videoId)){
            Video vidObj = map.get(videoId);
            //System.out.println("views - "+vidObj.views);
            return vidObj.views;
        }
        else{
            return -1;
        }
    }
}
