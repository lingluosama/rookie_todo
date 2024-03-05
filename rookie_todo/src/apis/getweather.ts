import {$http} from "@/apis/index";

export const getweather=(data:{key:string;location:string})=>{
    return $http({
        method:"get",
        url:"https://api.seniverse.com/v3/weather/now.json",
        params: data,
    })
}