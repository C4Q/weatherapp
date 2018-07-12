import Foundation

struct Weather {
    
    private let kSummary = "summary"
    private let kTemperature = "temperature"
    private let kTemperatureMin = "temperatureMin"
    private let kTemperatureMax = "temperatureMax"
    
    let summary: String
    let temperature: Double
    let temperatureMin: Double
    let temperatureMax: Double
    
    init?(json:[String:Any]) {
        guard let summary = json[kSummary] as? String else {
            return nil
        }
        
        guard let temperature = json[kTemperature] as? Double else {
           return nil
        }
        
        guard let temperatureMin = json[kTemperatureMin] as? Double else {
            return nil
        }
        
        guard let temperatureMax = json[kTemperatureMax] as? Double else {
            return nil
        }
        
        self.summary = summary
        self.temperature = temperature
        self.temperatureMax = temperatureMax
        self.temperatureMin = temperatureMin
    }
    
    func farenheitToCelcius() {
        
    }
}
