import axios from "axios";
import JSONbig from 'json-bigint';
import type { AxiosRequestConfig } from 'axios';
import { ElLoading, ElMessage } from "element-plus";
import { AxiosError } from "axios";

// 创建 Axios 实例
export const httpInstance = axios.create();

export type Status = {
    statuscode: number;
    statusmsg: string;
    succeed: boolean;
};

// 将 json-bigint 设置为 transformResponse
httpInstance.defaults.transformResponse = [
    function (data) {
        // 使用 json-bigint 解析响应数据
        try {
            return JSONbig.parse(data);
        } catch (error) {
            return data;
        }
    },
];

export const $http = async (config: AxiosRequestConfig) => {
    const loadingInstance = ElLoading.service();
    try {
        const axiosResponse = await httpInstance(config);
        const status = axiosResponse.data;
        return status;
    } catch (err) {
        if (err instanceof AxiosError) {
            console.log(err)
            ElMessage.error('请求失败');
        }
    } finally {
        loadingInstance.close();
    }
};
