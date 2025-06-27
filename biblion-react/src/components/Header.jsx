import * as img from '@/components/Image';

export default function Header(){
    return (
        <>
            <header className="flex justify-between p-3 bg-[#debcbe] dark:bg-gray-950">
            <div>
                <h1 className="mb-3 text-sm text-xl text-black uppercase dark:text-white">
                   BIBLION
                </h1>
            </div>
            </header>
        </>
    )
}
