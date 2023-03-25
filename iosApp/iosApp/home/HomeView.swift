import SwiftUI
import shared

struct HomeView: View {
    @ObservedObject var viewModel: HomeViewModel = HomeViewModel()

       var body: some View {
          
           if(viewModel.state.isLoading){
               Text("loading")
               
           } else if (viewModel.state.isError) {
               Text("something went wrong")
           } else {
               Text(viewModel.state.vyaparEmployees.description)
           }
       }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		HomeView()
	}
}
