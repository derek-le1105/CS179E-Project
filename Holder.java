import java.util.*;;

class Holder{
    //superClass, fields, methods
    String SC;
    Map<String, String> fields = new HashMap<>();
    Map<String, String> methods = new HashMap<>();
    Map<String, Map<String, String>> hold = new HashMap<>(); //Change < p1, int>>
    
    public Holder(){
        
    }
    
    public void SC_input(String str1){
        SC = str1;
    }
    //lhs = id, rhs = type
    public void field_input(String id, String type){
        fields.put(id, type);
    }
    
    public void met_input(String id, String type){
        methods.put(id, type);
    }
  
    public void hold_input(String str1, String str2, String str3){
      Map<String, String> inner = hold.get(str1);
      if(inner == null){
          inner = new HashMap<>();
      hold.put(str1, inner);
      }
      inner.put(str2, str3);
    }
    
    public String get_SC(String str){
        return SC;
    }
  
    public String get_hold(String str1, String str2){
      return hold.get(str1).get(str2);
    }
    
    public String get_field(String str){
        return fields.get(str);
    }
    
    public String get_met(String str){
        return methods.get(str);
    }
  
    public int hold_size(String str){
      return hold.get(str).size();
    }

    public String printEverything(){
        String output = "    SC: " + this.SC + '\n' + 
                        "    Fields:" + this.fields + '\n' +
                        "    Methods: " + this.methods + '\n';
        return output;
    }
  }