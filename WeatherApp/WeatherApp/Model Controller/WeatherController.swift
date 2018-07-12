import Foundation

class WeatherController {
    
    static let shared = WeatherController()
    let apiStringKey = "https://api.darksky.net/forecast/41ca2cd5a5e9bd8f6a40ee15d20bf9ca/40.730610,-73.935242"
    
    var forecasts: [Weather] = []
    
    func forecastNYC() {
        
        guard let apiURL = URL(string: apiStringKey) else {
            return
        }

        NetworkController.performRequest(for: apiURL, httpMethod: .get) { (data, error) in
            guard let data = data else {
                return
                
            }
            guard let jsonDictionary = (try? JSONSerialization.jsonObject(with: data, options: .allowFragments)) as? [String:Any] else {
                return
            }
            
            guard let responseDictionary = jsonDictionary["daily"] as? [String:Any] else {
                return
            }
            
            guard let dailyData = responseDictionary["data"] as? [[String:Any]] else {
                return
            }
            
            for dataPoint in dailyData {
                if let weather = Weather(json: dataPoint) {
                    print(weather)
                }
            }
        }
    }
}
