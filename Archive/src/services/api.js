import axios from 'axios';
 
const url={
    baseUrl:"http://localhost:8080/api",
    departments:"/departments",
    employees:"/employees"
};

const instance=axios.create({
    baseURL:url.baseUrl,
    headers:{
        "Content-Type":"application/json",
        "Accept":"application/json"
    },
});
export default{
    url:url,
    axios:instance,
    get:instance.get,
    put:instance.put,
    post:instance.post,
    delete:instance.delete
}