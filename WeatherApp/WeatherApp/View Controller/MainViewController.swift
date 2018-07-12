import UIKit

class MainViewController: UIViewController {

    
    @IBOutlet var tableView: UITableView!
    private var backgroundImageView: UIImageView!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        tableView.delegate = self
        tableView.dataSource = self
        backgroundImageView = UIImageView(frame: CGRect(x: 0, y: 0, width: 0, height: 0))
        self.view.addSubview(backgroundImageView)
        WeatherController.shared.forecastNYC()
    }
    
    override func viewWillLayoutSubviews() {
        tableView.alpha = 0.9
        tableView.separatorStyle = .none
        
        self.view.sendSubview(toBack: backgroundImageView)
        backgroundImageView.frame = self.view.frame
        backgroundImageView.contentMode = .scaleAspectFill
        backgroundImageView.image = #imageLiteral(resourceName: "nyc")
    }
    
    // MARK: - Navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "detailSegue" {
            if let destinationVC = segue.destination as? DetailViewController {
                // setup detail
                // if let weather = WeatherController.shared.forecasts[index.path.row] {
                // destinationVC.weather = weather
            }
        }
    }
 

}

// MARK: - Helper Methods
extension MainViewController {
    
    private func initilizeBarButton() {
        let tempratureUnitConvertBarButton = UIBarButtonItem(title: "F/C", style: .plain, target: self, action: #selector(convertTemperatureUnits))
        
    }
    
    @objc func convertTemperatureUnits() {
        // call convert method on weather
    }
}

extension MainViewController: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return WeatherController.shared.forecasts.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "weatherCell", for: indexPath)
        return cell
    }
}
