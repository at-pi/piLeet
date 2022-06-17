class UndergroundSystem {
    
    class Average{
        double avgTime;
        int avgNum;
        public Average(double avgTime, int avgNum){
            this.avgTime = avgTime;
            this.avgNum = avgNum;
        }
    }
    
    class CheckIn{
        String stationName;
        int time;
        public CheckIn(String stationName, int time){
            this.stationName = stationName;
            this.time = time;
        }
    }
    
    
    Map<Integer, CheckIn> checkedIn;
    Map<String, Average> timeMap;
    
    public UndergroundSystem() {
        this.checkedIn = new HashMap<>();
        this.timeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        CheckIn checkIn = new CheckIn(stationName, t);
        this.checkedIn.put(id, checkIn);
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = this.checkedIn.get(id);
        int duration = t-checkIn.time;
        String entry = checkIn.stationName + "-" + stationName;
        Average newAvg;
        if(timeMap.containsKey(entry)){
            newAvg = timeMap.get(entry);
            double avgTime = ((newAvg.avgTime * newAvg.avgNum) + duration)/(newAvg.avgNum + 1);
            this.timeMap.put(entry, new Average(avgTime, newAvg.avgNum + 1));
        }
        else{
            newAvg = new Average(duration, 1);
            this.timeMap.put(entry, newAvg);
        }
        this.checkedIn.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String entry = startStation + "-" + endStation;
        return timeMap.get(entry).avgTime;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */