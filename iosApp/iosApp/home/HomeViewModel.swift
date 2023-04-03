//
//  HomeViewModel.swift
//  iosApp
//
//  Created by HEMANTH on 24/03/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension HomeView {
    
    public class HomeViewModel: ObservableObject {
        
        @Published var state: VyaparEmployeeState = VyaparEmployeeState(vyaparEmployees: [],
                                                                        isLoading: false,
                                                                        isError: false)
        
        
        init() {
            
            let getVyaparEmployee = GetVyaparEmployees(repository : EmployeeRepositoryImpl())
            
            
            
            getVyaparEmployee.invoke().watch { value in

                if(value is SharedResourceSuccess){
                    
                    let vyaparEmployees = (value?.data ?? []) as! [VyaparEmployee]
                    
                    self.state = VyaparEmployeeState(vyaparEmployees: vyaparEmployees,
                                                     isLoading: false,
                                                     isError: false)
                    
                }else if value is SharedResourceError {
                    self.state = VyaparEmployeeState(vyaparEmployees: [],
                                                     isLoading: false,
                                                     isError: true)
                    
                }else  if value is SharedResourceLoading {
                    self.state = VyaparEmployeeState(vyaparEmployees: [],
                                                     isLoading: true,
                                                     isError: true)
                    
                }
            }
        }
    }
}
