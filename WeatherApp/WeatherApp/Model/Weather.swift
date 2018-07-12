import Foundation

struct Weather {
    
    
    let summary: String
    let icon: String
    let temprature: Double
    let temperatureMin: Double
    let tempratureMax: Double
    
    init?(json:[String:Any]) {
        guard let summary = json["summary"] as? String else {
            return nil
        }
        
        guard let icon = json["icon"] as? String else {
            return nil
        }
        
        guard let temprature = json["temprature"] as? Double else {
           return nil
        }
        
        guard let temperatureMin = json["temperatureMin"] as? Double else {
            return nil
        }
        
        guard let tempratureMax = json["tempratureMax"] as? Double else {
            return nil
        }
        
        self.summary = summary
        self.temprature = temprature
        self.tempratureMax = tempratureMax
        self.icon = icon
        self.temperatureMin = temperatureMin
    }
    
    
//    static func forecastNYC(completion: @escaping (([Weather]) -> ())){
//        let path = "https://api.darksky.net/forecast/41ca2cd5a5e9bd8f6a40ee15d20bf9ca/40.730610,-73.935242"
//        var forecast: [Weather] = []
//        if let apiURL = URL(string: path) {
//            NetworkController.performRequest(for: apiURL, httpMethod: .get) { (data, error) in
//                guard let data = data,
//                    let responseDataString = String(data: data, encoding: .utf8) else {
//                        print("No data returned from network request.")
//                        return
//                }
//                
//                guard let jsonDictionary = (try? JSONSerialization.jsonObject(with: data, options: .allowFragments)) as? [String:Any] else {
//                    print("Unable to serialize json")
//                    return
//                }
//                
//                guard let responseDictionary = jsonDictionary["daily"] as? [String:Any] else {
//                    print(responseDataString)
////                    completion([])
//                    return
//                }
//                guard let dailyData = responseDictionary["data"] as? [[String:Any]] else {
//                    print(responseDataString)
////                    completion([])
//                    return
//                }
//                for data in dailyData {
//                    if let weatherObject = try? Weather(json: data) {
//                        forecast.append(weatherObject)
//                    }
//                }
//                
//                completion(forecast)
//            }
//        }
//    }
    
    /*
     private let kAvgTempC = "avgTempC"
     private let kAvgTempF = "avgTempF"
     private let kMinTempC = "minTempC"
     private let kMinTempF = "minTempF"
     private let kMaxTempC = "maxTempC"
     private let kMaxTempF = "maxTempF"
     
     
     let avgTempC: String
     let avgTempF: String
     let minTempC: String
     let minTempF: String
     let maxTempC: String
     let maxTempF: String
     
     init?(dictionary: [String:Any]) {
     guard let avgTempC = dictionary[kAvgTempC] as? String,
     let avgTempF = dictionary[kAvgTempF] as? String,
     let minTempC = dictionary[kMinTempC] as? String,
     let minTempF = dictionary[kMinTempF] as? String,
     let maxTempC = dictionary[kMaxTempC] as? String,
     let maxTempF = dictionary[kMaxTempF] as? String else { return nil }
     
     self.avgTempC = avgTempC
     self.avgTempF = avgTempF
     self.minTempC = minTempC
     self.minTempF = minTempF
     self.maxTempC = maxTempC
     self.maxTempF = maxTempF
     }
     */
}
