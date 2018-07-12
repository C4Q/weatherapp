import Foundation

class WeatherController {
    
    static let shared = WeatherController()
    let apiUrlString = "https://api.aerisapi.com/forecasts/11101?client_id=wmYzgqM9fPAGGxUROpWdY&client_secret=DwBMkf0OZoEGcKdgccIxGJFXdd6sdh3G89PEhqZY"
    
    func fetchData() {
        guard let apiURL = URL(string: apiUrlString) else { return }
        
        NetworkController.performRequest(for: apiURL, httpMethod: .get, urlParameters: nil, body: nil) { (data, error) in
            
            guard let data = data,
                let responseDataString = String(data: data, encoding: .utf8) else {
                    print("No data returned from network request.")
                    return
            }
            
            guard let jsonDictionary = (try? JSONSerialization.jsonObject(with: data, options: .allowFragments)) as? [String:AnyObject] else { return }
            
            
            
            guard let responseDictionary = jsonDictionary["response"] as? [[String:AnyObject]] else {
                print("unable to serialize json. \nresponse: \(responseDataString)")
                    return
            }
            
            print(responseDataString)
            print(responseDictionary)

            
            
        }
    }
    
    
}
