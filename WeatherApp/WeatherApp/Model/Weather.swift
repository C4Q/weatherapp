import Foundation

struct Weather {
    
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
}
