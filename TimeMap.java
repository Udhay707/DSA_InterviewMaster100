import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class TimeMap {
    TreeMap<Integer, Map<String, String>> map;
    public TimeMap() {
        map = new TreeMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(timestamp)){
            map.put(timestamp, new HashMap<>());
        }
        var res = map.get(timestamp);
        res.put(key, value);
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(timestamp)){
            return map.get(timestamp).get(key);
        }
        return searchClosest(timestamp, key);
    }

    private String searchClosest(int timestamp, String key){
        Integer floorKey = map.floorKey(timestamp);
        Integer ceilKey = map.ceilingKey(timestamp);

        if(Objects.isNull(ceilKey) && Objects.isNull(floorKey)){
            return null;
        }

        if(Objects.isNull(ceilKey)){
            return map.get(floorKey).get(key);
        } else if(Objects.isNull(floorKey)){
            return map.get(ceilKey).get(key);
        } else if(timestamp - floorKey < ceilKey - timestamp){
            return map.get(floorKey).get(key);
        } else{
            return map.get(ceilKey).get(key);
        }
    }

    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo", "bar", 1);
        System.out.println(obj.get("foo", 1));
        System.out.println(obj.get("foo", 3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4));
        System.out.println(obj.get("foo", 5));
    }
}